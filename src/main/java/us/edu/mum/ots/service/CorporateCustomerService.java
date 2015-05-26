package us.edu.mum.ots.service;

import us.edu.mum.ots.domain.CorporateCustomer;

/**
 *
 * @author bipin
 */
public interface CorporateCustomerService extends AbstractService<CorporateCustomer, Integer>{
    
    public CorporateCustomer findByEmail(String email);
}
