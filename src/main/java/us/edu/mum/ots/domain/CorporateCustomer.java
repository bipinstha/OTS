package us.edu.mum.ots.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author dinesh
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "corporate_customer")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class CorporateCustomer extends Customer {

    @Column(name = "credit_limit")
    private double creditLimit;

    public CorporateCustomer() {
        super.setCustomerType(CustomerType.CORPORATE_CUSTOMER);
    }

    public CorporateCustomer(String name, Integer zipcode, String street, String city, String state, String emailId, String mobileNo) {
        super(name, zipcode, street, city, state, emailId, mobileNo, CustomerType.CORPORATE_CUSTOMER);
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    double GetDiscount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
