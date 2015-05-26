package us.edu.mum.ots.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.edu.mum.ots.dao.CorporateCustomerDAO;
import us.edu.mum.ots.domain.CorporateCustomer;
import us.edu.mum.ots.service.CorporateCustomerService;

/**
 *
 * @author bipin
 */
@Service("CorporateCustomerService")
class CorporateCustomerServiceImpl implements CorporateCustomerService {

    @Autowired
    private CorporateCustomerDAO customerDao;

    @Override
    @Transactional
    public void add(CorporateCustomer t) {
        this.customerDao.save(t);
    }

    @Override
    @Transactional
    public void update(CorporateCustomer t) {
        this.customerDao.save(t);
    }

    @Override
    public List<CorporateCustomer> findAll() {
        return this.customerDao.findAll();
    }

    @Override
    public CorporateCustomer findOne(Integer obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Invalid customer id.");
        }
        return this.customerDao.findOne(obj);
    }

    @Override
    public void delete(CorporateCustomer t) {
        if (t == null) {
            throw new IllegalArgumentException("Invalid customer.");
        }
        this.customerDao.delete(t);
    }

    @Override
    public CorporateCustomer findByEmail(String email) {
        return this.customerDao.findByEmail(email);
    }

}
