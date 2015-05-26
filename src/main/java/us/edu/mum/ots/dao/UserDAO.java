package us.edu.mum.ots.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import us.edu.mum.ots.domain.User;

/**
 *
 * @author bipin
 */
@Transactional(readOnly = true)
public interface UserDAO extends JpaRepository<User, Integer> {

    /**
     *
     * @param userName
     * @return
     */
    public User findByUserName(String userName);
}
