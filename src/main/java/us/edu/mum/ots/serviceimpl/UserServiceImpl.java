package us.edu.mum.ots.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import us.edu.mum.ots.dao.UserDAO;
import us.edu.mum.ots.domain.User;
import us.edu.mum.ots.service.UserService;

/**
 *
 * @author bipin
 */
@Service("UserService")
class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;

    @Override
    public void add(User t) {
        t.setPassword(encryptString(t.getPassword()));
        this.userDao.save(t);
    }

    @Override
    public void update(User t) {
        this.userDao.save(t);
    }

    @Override
    public List<User> findAll() {
        return this.userDao.findAll();
    }

    @Override
    public User findOne(Integer obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Invalid id");
        }
        return this.userDao.findOne(obj);
    }

    @Override
    public void delete(User t) {
        if (t == null) {
            throw new IllegalArgumentException("Invalid user.");
        }
        this.userDao.delete(t);
    }

    @Override
    public User findByUserName(String userName) {
        return this.userDao.findByUserName(userName);
    }

    private String encryptString(String text) {
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        return encoder.encodePassword(text, null);
    }
}
