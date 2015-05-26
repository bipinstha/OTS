package us.edu.mum.ots.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import us.edu.mum.ots.domain.PersonnelCustomer;

/**
 *
 * @author bipin
 */
@Transactional(readOnly = true)
public interface PersonnelCustomerDAO extends JpaRepository<PersonnelCustomer, Integer> {

    public PersonnelCustomer findByEmail(String email);

}
