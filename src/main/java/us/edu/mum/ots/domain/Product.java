package us.edu.mum.ots.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author dinesh
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "product_name", length = 50, nullable = false)
    private String productName;
    @Column(name = "product_number", length = 50)
    private String productNo;
    @Column(name = "description", length = 255, nullable = false)
    private String description;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "product_type", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    @Column(name = "status", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "registered_date", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date registeredDate;
    @Column(name = "available_quantity")
    private Integer availableQuantity;
    @Column(name = "sold_quantity")
    private Integer soldQuantity;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL)
    private OrderDetail orderDetail;

    public Product() {
        this.status = Status.AVAILABLE;
        this.registeredDate = new Date();
    }

    public Product(String productName, String productNo, String description, Double price, ProductType productType, Integer availabelQuantity) {
        this.status = Status.AVAILABLE;
        this.registeredDate = new Date();
        this.productName = productName;
        this.productNo = productNo;
        this.description = description;
        this.price = price;
        this.productType = productType;
        this.availableQuantity = availabelQuantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull(message = "Product name cannot be empty.")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String ProductName) {
        this.productName = ProductName;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    @NotNull(message = "Product Description cannot be empty.")
    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    @NotNull(message = "Price cannot be empty.")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @NotNull(message = "Product type cannot be empty.")
    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Integer getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(Integer soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public enum Status {

        NOT_AVAILABLE, AVAILABLE
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", productName=" + productName + ", productNo=" + productNo + ", description=" + description + ", price=" + price + ", productType=" + productType + ", status=" + status + ", registeredDate=" + registeredDate + ", quantity=" + availableQuantity + '}';
    }

}
