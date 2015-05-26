package us.edu.mum.ots.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import us.edu.mum.ots.domain.User;

/**
 *
 * @author bipin
 */
@Component("assembler")
@Scope("singleton")
public class Assembler implements Serializable {

    private static final long serialVersionUID = 1L;

    CustomSpringSecurityUser buildUserFromUserEntity(User user) {
        String username = user.getUserName();
        String password = user.getPassword();
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        Collection<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
        authority.add(new SpringAuthority("ADMIN"));
        CustomSpringSecurityUser cssu = new CustomSpringSecurityUser(username, password, enabled,
                accountNonExpired, credentialsNonExpired, accountNonLocked, authority, user.getFirstName(), user.getMiddleName(), user.getLastName());

        return cssu;
    }

    private class SpringAuthority implements GrantedAuthority {

        private static final long serialVersionUID = 5317479113915801691L;
        private final String authority;

        public SpringAuthority(final String authority) {
            this.authority = authority;
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (this.getClass() != obj.getClass()) {
                return false;
            }
            SpringAuthority other = (SpringAuthority) obj;
            if (authority == null) {
                if (other.authority != null) {
                    return false;
                }
            } else if (!authority.equals(other.authority)) {
                return false;
            }
            return true;
        }

        @Override
        public String getAuthority() {
            return authority;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = prime * (authority == null ? 0 : authority.hashCode());
            return result;
        }
    }
}
