package us.edu.mum.ots.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import us.edu.mum.ots.domain.Customer.CustomerType;

/**
 *
 * @author dinesh
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "total_price", nullable = false)
    private double totalPrice;
    @Column(name = "discount_percentage")
    private Double discountPercentage;
    @Column(name = "pay_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private PayType status;
    @Column(name = "order_date", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date orderDate;
    @Column(name = "shipped_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date shippedDate;
    @Column(name = "customer_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private CustomerType customerType;
    @Column(name = "customer_id")
    private Integer customerId;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<OrderDetail> orderDetail;

    public Order() {
        this.orderDetail = new ArrayList<>();
        this.orderDate = new Date();
        for (OrderDetail od : orderDetail) {
            this.totalPrice += od.getTotalPrice();
        }
    }

    public Order(PayType status, Integer customer, List<OrderDetail> orderDetail) {
        this();
        this.status = status;
        this.customerId = customer;
        this.orderDetail = orderDetail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @NotNull(message = "Pay type cannot be null.")
    public PayType getStatus() {
        return status;
    }

    public void setStatus(PayType status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    @NotNull(message = "Customer cannot be null.")
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @NotNull(message = "Order detail cannot be empty.")
    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }

    @NotNull(message = "Customer cannot be empty.")
    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public enum PayType {

        PAID, UNPAID, CREDIT
    }
}
