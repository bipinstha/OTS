package us.edu.mum.ots.controller;

import java.util.logging.Level;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import us.edu.mum.ots.web.spring.FacesUtils;

/**
 *
 * @author bipin
 */
@Component("loginBean")
@Scope("request")
public class LoginController {

    private String username;
    private String password;
    @Autowired
    @Qualifier("authenticator")
    private AuthenticationManager am;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginController.class.getName());

    @NotNull(message = "User name required")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull(message = "Password required")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String loginProcess() {
        try {
            Authentication request = new UsernamePasswordAuthenticationToken(
                    this.getUsername(), this.getPassword());
            Authentication result = am.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);
        } catch (AuthenticationException e) {
            logger.log(Level.INFO, "error: {0}", e.getMessage());
            FacesUtils.addErrorMessage("Login Failed");
            return "";
        }
        return "pretty:home";
    }
}
