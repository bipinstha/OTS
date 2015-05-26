package us.edu.mum.ots.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.edu.mum.ots.dao.PersonnelCustomerDAO;
import us.edu.mum.ots.domain.PersonnelCustomer;
import us.edu.mum.ots.service.PersonnelCustomerService;

/**
 *
 * @author bipin
 */
@Service("PersonnelCustomerService")
class PersonnelCustomerServiceImpl implements PersonnelCustomerService {

    @Autowired
    private PersonnelCustomerDAO customerDao;

    @Override
    @Transactional
    public void add(PersonnelCustomer t) {
        if (t == null) {
            throw new IllegalArgumentException("Invalid customer");
        }
        this.customerDao.save(t);
    }

    @Override
    @Transactional
    public void update(PersonnelCustomer t) {
        if (t == null) {
            throw new IllegalArgumentException("Invalid customer");
        }
        this.customerDao.save(t);
    }

    @Override
    public List<PersonnelCustomer> findAll() {
        return this.customerDao.findAll();
    }

    @Override
    public PersonnelCustomer findOne(Integer obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Invalid customer");
        }
        return this.customerDao.findOne(obj);
    }

    @Override
    public void delete(PersonnelCustomer t) {
        if (t == null) {
            throw new IllegalArgumentException("Invalid customer");
        }
        this.customerDao.delete(t);
    }

    @Override
    public PersonnelCustomer findByEmail(String email) {
        return this.customerDao.findByEmail(email);
    }

}
