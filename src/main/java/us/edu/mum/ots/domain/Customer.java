package us.edu.mum.ots.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author dinesh
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class Customer implements Serializable {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "full_name", length = 100, nullable = false)
    private String name;
    @Column(name = "zip_code", length = 50, nullable = false)
    private Integer zipcode;
    @Column(name = "street", length = 50, nullable = false)
    private String street;
    @Column(name = "city", length = 50, nullable = false)
    private String city;
    @Column(name = "state", length = 50, nullable = false)
    private String state;
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;
    @Column(name = "mobile_no", length = 20, nullable = false)
    private String mobileNo;
    @Column(name = "credit_rating", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private Rating creditRating = Rating.POOR;
    @Column(name = "total_points")
    private double totalPoints;
    @Column(name = "customer_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private CustomerType customerType;

    public Customer() {
    }

    public Customer(String name, Integer zipcode, String street, String city, String state, String emailId, String mobileNo, CustomerType customerType) {
        this.name = name;
        this.zipcode = zipcode;
        this.street = street;
        this.city = city;
        this.state = state;
        this.email = emailId;
        this.mobileNo = mobileNo;
        this.customerType = customerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull(message = "Customer Name cannot be empty.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rating getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(Rating creditRating) {
        this.creditRating = creditRating;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(double totalPoints) {
        this.totalPoints = totalPoints;
    }

    @NotNull(message = "ZipCode cannot be empty.")
    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    @NotNull(message = "Street cannot be empty.")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @NotNull(message = "City cannot be empty.")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @NotNull(message = "State cannot be empty.")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Email
    @NotNull(message = "Email cannot be empty.")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull(message = "Mobile cannot be empty.")
    @Pattern(regexp = "[0-9\\s]{9,15}", message = "Mobile must be numeric with minimum 9 characters.")
    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @NotNull(message = "Customer type cannot be null")
    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    
    abstract double GetDiscount();

    public enum Rating {

        POOR, GOOD, EXCELLENT
    }

    public enum CustomerType {

        CORPORATE_CUSTOMER, PERSONNEL_CUSTOMER
    }
}
