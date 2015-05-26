/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.edu.mum.ots.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.model.SelectItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.edu.mum.ots.controller.PersonalController;
import us.edu.mum.ots.domain.CorporateCustomer;
import us.edu.mum.ots.domain.Customer;
import us.edu.mum.ots.domain.PersonnelCustomer;
import us.edu.mum.ots.domain.Product;
import us.edu.mum.ots.domain.ProductType;
import us.edu.mum.ots.service.CorporateCustomerService;
import us.edu.mum.ots.service.PersonnelCustomerService;
import us.edu.mum.ots.service.ProductService;

/**
 *
 * @author dinesh
 */
@Component("helperBean")
public class Helper {

     private static final Logger logger = Logger.getLogger(PersonalController.class.getName());
   
    @Autowired
    private CorporateCustomerService corporateservice;
    @Autowired
    private PersonnelCustomerService personalservice;

     @Autowired
    private ProductService productservice;

    public SelectItem[] getProductTypes() {
        ProductType[] types = ProductType.values();
        List<ProductType> list = new ArrayList<>();
        list.addAll(Arrays.asList(types));
        return toArrayOfSelectItem(list);
    }

//    public SelectItem[] getCorporateCustomer() {
//        if ("Corporate".equals(customerType)) {
//            List<CorporateCustomer> list;
//            list = corporateservice.findAll();
//            return toArrayOfSelectItem(list);
//        } else {
//            List<PersonnelCustomer> list;
//            list = personalservice.findAll();
//            return toArrayOfSelectItem(list);
//        }
//    }
    
     public List<CorporateCustomer> getCorporateCustomers() {
        return  this.corporateservice.findAll();
//        List<String> items = new ArrayList<>();
//        for (CorporateCustomer u : fetchedUsers) {
//            items.add(u.getName());
//        }
//        return items;
     }
     
     public List<PersonnelCustomer> getPersonnelCustomers() {
        return this.personalservice.findAll();
//        List<String> items = new ArrayList<>();
//        for (PersonnelCustomer u : fetchedUsers) {
//            items.add(u.getName());
//        }
//        return items;
     }

    public <T> SelectItem[] toArrayOfSelectItem(List<T> obj) {
        SelectItem[] items = new SelectItem[obj.size()];
        int index = 0;
        for (T r : obj) {
            items[index] = new SelectItem(r);
            index++;
        }
        return items;
    }
}
