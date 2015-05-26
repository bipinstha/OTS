package us.edu.mum.ots.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import us.edu.mum.ots.domain.Product;
import us.edu.mum.ots.domain.ProductType;

/**
 *
 * @author bipin
 */
@Transactional(readOnly = true)
public interface ProductDAO extends JpaRepository<Product, Integer> {

    /**
     *
     * @param productType
     * @return
     */
    public List<Product> findByProductType(ProductType productType);
}
