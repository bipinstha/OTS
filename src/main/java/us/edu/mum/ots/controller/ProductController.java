package us.edu.mum.ots.controller;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import us.edu.mum.ots.domain.Product;
import us.edu.mum.ots.service.ProductService;
import us.edu.mum.ots.web.spring.FacesUtils;

/**
 *
 * @author dinesh
 */
@Component("productBean")
@Scope("view")
public class ProductController {

    private static final Logger logger = Logger.getLogger(ProductController.class.getName());
    @Autowired
    private ProductService service;
    private Product instance;

    public Product getInstance() {
        return instance;
    }

    public ProductController() {
        this.instance = new Product();
    }

    public String onSave() {
        logger.info("Save button clicked.");
        try {
            this.service.add(instance);
            FacesUtils.addSuccessMessage("New Product Added successfully.");
            return "pretty:productlist";
        } catch (IllegalArgumentException ex) {
            FacesUtils.addErrorMessage(ex.getMessage());
        }
        return "";
    }

    public List<Product> getProductList() {
        return this.service.findAll();
    }
}
