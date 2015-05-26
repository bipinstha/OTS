package us.edu.mum.ots.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author bipin
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "ordered_quantity", nullable = false)
    private Integer orderedQuantity;
    @Column(name = "shipped_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date shippedDate;
    @Column(name = "order_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @Column(name = "total_price", nullable = false)
    private double totalPrice;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @GenericGenerator(name = "generator", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "product"))
    @GeneratedValue(generator = "generator")
    @JoinColumn(name = "product_id", unique = true, nullable = false)
    @OneToOne
    private Product product;

    public OrderDetail() {
    }

    public OrderDetail(Integer orderedQuantity, OrderStatus orderStatus, Order order, Product product) {
        this.orderedQuantity = orderedQuantity;
        this.orderStatus = orderStatus;
        this.order = order;
        this.product = product;
        this.totalPrice = product.getPrice() * this.orderedQuantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull(message = "Order quantity cannot be 0.")
    public Integer getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(Integer orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getTotalPrice() {
        this.totalPrice = product.getPrice() * this.orderedQuantity;
        return this.product.getPrice() * this.orderedQuantity;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @NotNull(message = "Order cannot be null.")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @NotNull(message = "Product cannot be null.")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public enum OrderStatus {

        PENDING, SHIPPED
    }

}
