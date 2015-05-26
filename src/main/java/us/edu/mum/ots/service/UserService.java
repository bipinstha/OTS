package us.edu.mum.ots.service;

import us.edu.mum.ots.domain.User;

/**
 *
 * @author bipin
 */
public interface UserService extends AbstractService<User, Integer> {

    public User findByUserName(String userName);
}
