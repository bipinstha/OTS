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
import us.edu.mum.ots.domain.CorporateCustomer;
import us.edu.mum.ots.service.CorporateCustomerService;
import us.edu.mum.ots.web.spring.FacesUtils;

/**
 *
 * @author dinesh
 */
@Component("customerBean")
@Scope("view")
public class CorporateController {

    //private UserService service;
    private static final Logger logger = Logger.getLogger(CorporateController.class.getName());
    @Autowired
    private CorporateCustomerService service;
    private CorporateCustomer instance;

    public CorporateCustomer getInstance() {
        return instance;
    }

    public CorporateController() {
        this.instance = new CorporateCustomer();
        this.instance.setCity("Fairfield");
    }

    public List<CorporateCustomer> getCustomerList(){
        return this.service.findAll();
    }
    public String onSave() {
        logger.info("Save button clicked.");
//        if (!this.instance.getPassword().equals(this.rePassword)) {
//            FacesUtils.addErrorMessage("Invalid password.");
//        }
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
