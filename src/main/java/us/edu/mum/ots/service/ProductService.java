package us.edu.mum.ots.service;

import java.util.List;
import us.edu.mum.ots.domain.Product;
import us.edu.mum.ots.domain.ProductType;

/**
 *
 * @author bipin
 */
public interface ProductService extends AbstractService<Product, Integer> {

    public List<Product> findByProductType(ProductType productType);
}
