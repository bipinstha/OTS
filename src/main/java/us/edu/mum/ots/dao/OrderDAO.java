package us.edu.mum.ots.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import us.edu.mum.ots.domain.Order;

/**
 *
 * @author bipin
 */
@Transactional(readOnly = true)
public interface OrderDAO extends JpaRepository<Order, Integer>{
    
}
