package us.edu.mum.ots.service.test;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import us.edu.mum.ots.domain.Customer;
import us.edu.mum.ots.domain.Order;
import us.edu.mum.ots.domain.OrderDetail;
import us.edu.mum.ots.domain.Product;
import us.edu.mum.ots.domain.ProductType;
import us.edu.mum.ots.service.OrderService;
import us.edu.mum.ots.service.PersonnelCustomerService;
import us.edu.mum.ots.service.ProductService;

/**
 *
 * @author bipin
 */
public class OrderServiceTest extends BaseTest {

    @Autowired
    private OrderService orderService;
    @Autowired
    private PersonnelCustomerService customerService;
    @Autowired
    private ProductService productService;

    @Test(dependsOnMethods = {"us.edu.mum.pms.service.test.CustomerServiceTest.addPersonnelCustomer", "us.edu.mum.pms.service.test.ProductServiceTest.addProductTest"})
    public void orderProduct() {
        Customer c = this.customerService.findByEmail("ram@mum.edu");
        Product product = this.productService.findByProductType(ProductType.HEALTH_RELATED).get(0);
        List<OrderDetail> details = new ArrayList<>();
        System.out.println("price: " + product.getPrice());
        Order order = new Order();

        order.setCustomerId(c.getId());
        order.setCustomerType(c.getCustomerType());
        order.setStatus(Order.PayType.PAID);
        OrderDetail od = new OrderDetail(1, OrderDetail.OrderStatus.SHIPPED, order, product);
        details.add(od);
        order.setOrderDetail(details);
        System.out.println("get total amount to pay: " + order.getTotalPrice());
        this.orderService.add(order);

    }

}
