package us.edu.mum.ots.service;

import us.edu.mum.ots.domain.PersonnelCustomer;

/**
 *
 * @author bipin
 */
public interface PersonnelCustomerService extends AbstractService<PersonnelCustomer, Integer> {

    public PersonnelCustomer findByEmail(String email);
}
