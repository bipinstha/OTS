package us.edu.mum.ots.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.edu.mum.ots.dao.ProductDAO;
import us.edu.mum.ots.domain.Product;
import us.edu.mum.ots.domain.ProductType;
import us.edu.mum.ots.service.ProductService;

/**
 *
 * @author bipin
 */
@Service("ProductService")
class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDao;

    @Override
    @Transactional
    public void add(Product t) {
        if (t == null) {
            throw new IllegalArgumentException("Invalid product");
        }
        this.productDao.save(t);
    }

    @Override
    @Transactional
    public void update(Product t) {
        if (t == null) {
            throw new IllegalArgumentException("Invalid product");
        }
        this.productDao.save(t);
    }

    @Override
    public List<Product> findAll() {
        return this.productDao.findAll();
    }

    @Override
    public Product findOne(Integer obj) {
        return this.productDao.findOne(obj);
    }

    @Override
    @Transactional
    public void delete(Product t) {
        if (t == null) {
            throw new IllegalArgumentException("Invalid product");
        }
        this.productDao.delete(t);
    }

    @Override
    public List<Product> findByProductType(ProductType productType) {
        return this.productDao.findByProductType(productType);
    }

}
