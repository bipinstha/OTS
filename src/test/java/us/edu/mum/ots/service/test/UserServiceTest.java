package us.edu.mum.ots.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.edu.mum.ots.domain.User;
import us.edu.mum.ots.service.UserService;

/**
 *
 * @author bipin
 */
public class UserServiceTest extends BaseTest {

    private static final String FIRST_NAME = "Bipin";
    private static final String MIDDLE_NAME = "";
    private static final String LAST_NAME = "Shrestha";
    private static final String USER_NAME = "aakee.stha@gmail.com";
    private static final String PASSWORD = "shrestha";
    private static final String ADDRESS = "1000N 4th street, fairfield, IOWA";
    private static final String MOBILE = "3196140230";

    @Autowired
    private UserService service;

    @Test
    public void addUserTest() {
        User user = new User(USER_NAME, PASSWORD, FIRST_NAME, MIDDLE_NAME, LAST_NAME, ADDRESS, MOBILE);
        this.service.add(user);
        User user1 = this.service.findByUserName(USER_NAME);
        Assert.assertEquals(USER_NAME, user1.getUserName());
    }
}
