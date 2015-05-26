package us.edu.mum.ots.serviceimpl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.edu.mum.ots.dao.OrderDAO;
import us.edu.mum.ots.domain.CorporateCustomer;
import us.edu.mum.ots.domain.Customer;
import us.edu.mum.ots.domain.Order;
import us.edu.mum.ots.domain.OrderDetail;
import us.edu.mum.ots.domain.PersonnelCustomer;
import us.edu.mum.ots.service.CorporateCustomerService;
import us.edu.mum.ots.service.OrderService;
import us.edu.mum.ots.service.PersonnelCustomerService;
import us.edu.mum.ots.service.ProductService;

/**
 *
 * @author bipin
 */
@Service("OrderService")
class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDao;
    @Autowired
    private ProductService productService;
    @Autowired
    private CorporateCustomerService corporateCustomerService;
    @Autowired
    private PersonnelCustomerService personnelCustomerService;

    @Override
    @Transactional
    public void add(Order t) {
        if (t == null) {
            throw new IllegalArgumentException("Invalid order");
        }
        for (OrderDetail od : t.getOrderDetail()) {
            if (od.getProduct().getAvailableQuantity() >= od.getOrderedQuantity()) {
                od.setOrderStatus(OrderDetail.OrderStatus.SHIPPED);
                od.setShippedDate(new Date());
            } else {
                od.setOrderStatus(OrderDetail.OrderStatus.PENDING);
            }
        }
        if (t.getCustomerType().equals(Customer.CustomerType.CORPORATE_CUSTOMER)) {
            this.addPointCorporateCustomer(t);
        } else {
            this.addPointPersonnelCustomer(t);
        }
        t.setShippedDate(new Date());

        this.orderDao.save(t);
    }

    private void addPointCorporateCustomer(Order order) {
        CorporateCustomer cc = this.corporateCustomerService.findOne(order.getCustomerId());
        int point = 0;
        for (OrderDetail od : order.getOrderDetail()) {
            point += od.getOrderedQuantity() * od.getProduct().getProductType().getPoint();
        }
        cc.setTotalPoints(cc.getTotalPoints() + point);
        if (order.getStatus().equals(Order.PayType.CREDIT)) {
            if (cc.getCreditLimit() >= order.getTotalPrice()) {
                cc.setCreditLimit(cc.getCreditLimit() - order.getTotalPrice());
                order.setStatus(Order.PayType.PAID);
            } else {
                throw new IllegalArgumentException("Insufficient credit limit");
            }
        }
        this.corporateCustomerService.update(cc);
    }

    private void addPointPersonnelCustomer(Order order) {
        PersonnelCustomer cc = this.personnelCustomerService.findOne(order.getCustomerId());
        int point = 0;
        for (OrderDetail od : order.getOrderDetail()) {
            point += od.getOrderedQuantity() * od.getProduct().getProductType().getPoint();
        }
        cc.setTotalPoints(cc.getTotalPoints() + point);
        this.personnelCustomerService.update(cc);
    }

    @Override
    @Transactional
    public void update(Order t) {
        if (t == null) {
            throw new IllegalArgumentException("Invalid order");
        }
        this.orderDao.save(t);
    }

    @Override
    public List<Order> findAll() {
        return this.orderDao.findAll();
    }

    @Override
    public Order findOne(Integer obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Invalid order");
        }
        return this.orderDao.findOne(obj);
    }

    @Override
    @Transactional
    public void delete(Order t) {
        if (t == null) {
            throw new IllegalArgumentException("Invalid order");
        }
        this.orderDao.delete(t);
    }

}
