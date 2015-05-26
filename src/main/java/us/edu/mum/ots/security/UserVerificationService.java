package us.edu.mum.ots.security;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import us.edu.mum.ots.service.UserService;

/**
 *
 * @author bipin
 */
@Component("userDetailsService")
@Scope("singleton")
public class UserVerificationService implements UserDetailsService, Serializable {

    @Autowired
    private Assembler assembler;
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        us.edu.mum.ots.domain.User user = this.userService.findByUserName(username);
        if (user == null) {
            throw new IllegalArgumentException("Username or password invalid");
        }
        if (user != null) {
            return this.assembler.buildUserFromUserEntity(user);
        }
        throw new UsernameNotFoundException("User name or password invalid");
    }
}
