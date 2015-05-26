package us.edu.mum.ots.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.edu.mum.ots.service.CorporateCustomerService;
import us.edu.mum.ots.service.OrderService;

/**
 *
 * @author bipin
 */
@Service("BillingService")
public class BillingService {
    
    @Autowired
    private CorporateCustomerService customerService;
    @Autowired
    private OrderService orderService;
    
    public double calcMonthlyBill(int month, int year){
    
        return 0.0;
    }
    
}
