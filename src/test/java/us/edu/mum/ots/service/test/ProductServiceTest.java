package us.edu.mum.ots.service.test;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.edu.mum.ots.domain.Product;
import us.edu.mum.ots.domain.ProductType;
import us.edu.mum.ots.service.ProductService;

/**
 *
 * @author bipin
 */
public class ProductServiceTest extends BaseTest {

    private static final String PRODUCT_NAME = "Keyboard";
    private static final String PRODUCT_NO = "k46";
    private static final String DESCRIPTION = "hp keyboard";
    private static final Double PRICE = 12.00;
    @Autowired
    private ProductService productService;

    @Test
    public void addProductTest() {
        Product p1 = new Product(PRODUCT_NAME, PRODUCT_NO, DESCRIPTION, PRICE, ProductType.COMPUTER_RELATED, 5);
        Product p2 = new Product("Mouse", "m61", "hp mouse", 5.00, ProductType.COMPUTER_RELATED, 6);
        Product p3 = new Product("Head Phone", "h41", "Beats Headphone", 30.00, ProductType.AUDIOVIDEO_RELATED, 4);
        Product p4 = new Product("Portable Hard disk", "h60", "Transcent Portable Hardisk", 80.91, ProductType.COMPUTER_RELATED, 3);
        Product p5 = new Product("Coughcerough", "p43", "honitosh", 30.00, ProductType.HEALTH_RELATED, 10);

        this.productService.add(p1);
        this.productService.add(p2);
        this.productService.add(p3);
        this.productService.add(p4);
        this.productService.add(p5);

        List<Product> list = this.productService.findByProductType(ProductType.COMPUTER_RELATED);
        Assert.assertEquals(list.size(), 3);
    }
}
