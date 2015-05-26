package us.edu.mum.ots.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.edu.mum.ots.domain.CorporateCustomer;
import us.edu.mum.ots.domain.PersonnelCustomer;
import us.edu.mum.ots.service.CorporateCustomerService;
import us.edu.mum.ots.service.PersonnelCustomerService;

/**
 *
 * @author bipin
 */
public class CustomerServiceTest extends BaseTest {

    @Autowired
    private CorporateCustomerService ccs;
    @Autowired
    private PersonnelCustomerService pcs;

    private static final String FULL_NAME = "Ram Kaji Ojha";
    private static final String CORPORATE = "LTD INC";
    private static final int ZIP_CODE = 52556;
    private static final String STREET = "1000N 4th STREET";
    private static final String CITY = "Fairfield";
    private static final String STATE = "IOWA";
    private static final String EMAIL = "corcus@mum.edu";
    private static final String EMAIL1 = "ram@mum.edu";
    private static final String MOBILE = "3145469087";
    private static final String MOBILE1 = "3145469087";

    @Test
    public void addCorporateCustomer() {
        CorporateCustomer cc = new CorporateCustomer(CORPORATE, ZIP_CODE, STREET, CITY, STATE, EMAIL, MOBILE);
        this.ccs.add(cc);
        CorporateCustomer c1 = this.ccs.findByEmail(EMAIL);
        Assert.assertEquals(EMAIL, c1.getEmail());
    }
    
    @Test
    public void addPersonnelCustomer(){
        PersonnelCustomer c = new PersonnelCustomer(FULL_NAME, ZIP_CODE, STREET, CITY, STATE, EMAIL1, MOBILE1);
        this.pcs.add(c);
        PersonnelCustomer pc = this.pcs.findByEmail(EMAIL1);
        Assert.assertEquals(EMAIL1, pc.getEmail());
        
    }
}
