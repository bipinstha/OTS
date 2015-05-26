package us.edu.mum.ots.controller;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import us.edu.mum.ots.domain.User;
import us.edu.mum.ots.web.spring.FacesUtils;
import us.edu.mum.ots.service.UserService;

/**
 *
 * @author bipin
 */
@Component("enrolmentBean")
@Scope("view")
public class EnrollmentController implements Serializable {

    @Autowired
    private UserService service;
    private static final Logger logger = Logger.getLogger(EnrollmentController.class.getName());

    private User instance;
    private String rePassword;

//    @PostConstruct
//    public void init() {
//        this.instance = new User();
//        this.instance.setUserName("aakee.stha@gmail.com");
//        logger.info("postconstruct");
//    }

    public EnrollmentController() {
        this.instance = new User();
        this.instance.setUserName("aakee.stha@gmail.com");
        logger.info("aakee.stha@gmail.com");
    }
    
    

    public User getInstance() {
        return instance;
    }

    public void setInstance(User instance) {
        this.instance = instance;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String onSave() {
        logger.info("Save button clicked.");
//        if (!this.instance.getPassword().equals(this.rePassword)) {
//            FacesUtils.addErrorMessage("Invalid password.");
//        }
        try {
            this.service.add(instance);
            FacesUtils.addSuccessMessage("User created successfully.");
            return "pretty:home";
        } catch (IllegalArgumentException ex) {
            FacesUtils.addErrorMessage(ex.getMessage());
        }
        return "";
    }

}
