package us.edu.mum.ots.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import us.edu.mum.ots.domain.CorporateCustomer;

/**
 *
 * @author bipin
 */
@Transactional(readOnly = true)
public interface CorporateCustomerDAO extends JpaRepository<CorporateCustomer, Integer> {

    public CorporateCustomer findByEmail(String email);
}
