package us.edu.mum.ots.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import us.edu.mum.ots.domain.Customer;
import us.edu.mum.ots.domain.Order;
import us.edu.mum.ots.domain.OrderDetail;
import us.edu.mum.ots.domain.Product;
import us.edu.mum.ots.domain.ProductType;
import us.edu.mum.ots.service.CorporateCustomerService;
import us.edu.mum.ots.service.OrderService;
import us.edu.mum.ots.service.PersonnelCustomerService;
import us.edu.mum.ots.service.ProductService;
import us.edu.mum.ots.web.spring.FacesUtils;

/**
 *
 * @author dinesh
 */
@Component("orderBean")
@Scope("view")
public class OrderController implements Serializable {

    @Autowired
    private ProductService productService;
    @Autowired
    private CorporateCustomerService corporateCustomerService;
    @Autowired
    private PersonnelCustomerService personnelCustomerService;
    @Autowired
    private OrderService orderService;
    private static final Logger logger = Logger.getLogger(OrderController.class.getName());
    private Order instance;
    private String productType = "COMPUTER_RELATED";
    private List<OrderDetail> orderDetails;
    private int productId;
    private String customerType;
    private String customerEmail;
    private int quantity=1;
    private Product product;
    private List<Integer> quantities;

    public OrderController() {
        orderDetails = new ArrayList<>();
        quantities = new ArrayList<>();
    }

    public Order getInstance() {
        return instance;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Integer> getQuantities() {
        this.quantities.clear();
        if (this.product != null) {
            for (int i = 1; i <= this.product.getAvailableQuantity(); i++) {
                quantities.add(i);
            }
        }
        return quantities;
    }

    public void setQuantities(List<Integer> quantities) {
        this.quantities = quantities;
    }

    public List<Product> getProducts() {
        logger.log(Level.INFO, "customerType: {0} customerEmail: {1}", new Object[]{customerType, customerEmail});
        logger.log(Level.INFO, "product type: {0}", productType);
        List<Product> fetchedUsers = this.productService.findByProductType(ProductType.valueOf(this.productType));
        return fetchedUsers;
    }

    public void findProduct() {
        this.product = this.productService.findOne(productId);
        logger.log(Level.INFO, "product Id: {0}", this.productId + " productName: " + this.product.getProductName());
    }

    public void onAdd() {
        logger.info("add button clicked");
        OrderDetail od = new OrderDetail(this.quantity, OrderDetail.OrderStatus.PENDING, instance, product);
        this.orderDetails.add(od);
        this.product = null;
//        this.quantities.clear();
//        this.quantity = 0;
    }

    public String onSave() {
        logger.info("Save button clicked.");
        Customer c = null;
        if (null != this.customerType) {
            switch (this.customerType) {
                case "CORPORATE":
                    this.instance.setCustomerType(Customer.CustomerType.CORPORATE_CUSTOMER);
                    c = this.corporateCustomerService.findByEmail(customerEmail);
                    break;
                case "PERSONNEL":
                    this.instance.setCustomerType(Customer.CustomerType.PERSONNEL_CUSTOMER);
                    c = this.personnelCustomerService.findByEmail(customerEmail);
                    break;
            }
        }
        this.instance.setCustomerId(c.getId());
        this.instance.setDiscountPercentage(c.getTotalPoints() >= 25 ? 40.00 : 0.00);
        this.instance.setOrderDetail(orderDetails);

        try {
            this.orderService.add(instance);
            FacesUtils.addSuccessMessage("Order Completed successfully.");
        } catch (IllegalArgumentException ex) {
            FacesUtils.addErrorMessage(ex.getMessage());
        }
        return "pretty:order";
    }

    public String onCancel() {
        return "pretty:order";
    }
}
