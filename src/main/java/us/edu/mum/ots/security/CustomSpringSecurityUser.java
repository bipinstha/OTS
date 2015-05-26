package us.edu.mum.ots.security;

import java.io.Serializable;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author bipin
 */
public class CustomSpringSecurityUser extends User implements Serializable {

    private String userFullName;
    private boolean ableToPerformTransactionFromWeb;

    public CustomSpringSecurityUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public CustomSpringSecurityUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, String userFirstName, String userMiddleName, String userLastName) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userFullName = userFirstName + " " + userMiddleName + " " + userLastName;
    }

    public boolean isAbleToPerformTransactionFromWeb() {
        return ableToPerformTransactionFromWeb;
    }

    public String getUserFullName() {
        return userFullName;
    }

}
