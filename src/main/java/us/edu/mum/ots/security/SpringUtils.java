package us.edu.mum.ots.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author bipin
 */
public class SpringUtils {

    public static CustomSpringSecurityUser getPrinciple() {
        CustomSpringSecurityUser user = null;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            Object principal = auth.getPrincipal();
            if (principal instanceof User) {
                user = (CustomSpringSecurityUser) principal;
            }
        }
        return user;
    }

    public static String getUserName() {
        CustomSpringSecurityUser user = getPrinciple();
        if (user != null) {
            return user.getUsername();
        }
        return "";
    }

    public static boolean hasUserLogIn() {
        return getPrinciple() != null;
    }
}
