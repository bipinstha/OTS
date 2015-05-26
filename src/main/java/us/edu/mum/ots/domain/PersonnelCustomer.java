package us.edu.mum.ots.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author bipin
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "personnel_customer")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class PersonnelCustomer extends Customer {

    public PersonnelCustomer() {
        super.setCustomerType(CustomerType.PERSONNEL_CUSTOMER);
    }

    public PersonnelCustomer(String name, Integer zipcode, String street, String city, String state, String emailId, String mobileNo) {
        super(name, zipcode, street, city, state, emailId, mobileNo, Customer.CustomerType.PERSONNEL_CUSTOMER);
    }

    @Override
    double GetDiscount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
