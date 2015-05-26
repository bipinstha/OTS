/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.edu.mum.ots.controller;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import us.edu.mum.ots.domain.PersonnelCustomer;
import us.edu.mum.ots.service.PersonnelCustomerService;
import us.edu.mum.ots.web.spring.FacesUtils;

/**
 *
 * @author dinesh
 */
@Component("personalBean")
@Scope("view")
public class PersonalController {
     //private UserService service;
    private static final Logger logger = Logger.getLogger(PersonalController.class.getName());
    @Autowired
    private PersonnelCustomerService service;
    private PersonnelCustomer instance;

    public PersonnelCustomer getInstance() {
        return instance;
    }

    public PersonalController() {
        this.instance = new PersonnelCustomer();
        this.instance.setCity("Fairfield");
    }

    public List<PersonnelCustomer> getCustomerList(){
        return this.service.findAll();
    }
    public String onSave() {
        logger.info("Save button clicked.");
 
        try {
            this.service.add(instance);
            FacesUtils.addSuccessMessage("Customer created successfully.");
            return "pretty:customer";
        } catch (IllegalArgumentException ex) {
            FacesUtils.addErrorMessage(ex.getMessage());
        }
        return "";
    }
}
