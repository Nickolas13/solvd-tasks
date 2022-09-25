package com.solvd.mybatis.service.services;

import com.solvd.mvc.dao.mysql.CustomerServiceDao;
import com.solvd.mvc.tables.Customer;
import com.solvd.mybatis.service.interfaces.ICustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static com.solvd.mybatis.service.MyBatis.close;
import static com.solvd.mybatis.service.MyBatis.getSession;

public class CustomersService implements ICustomerService {
    private static final Logger logger = LogManager.getLogger(CustomerServiceDao.class);

    @Override
    public Customer getById(int id) {
        try {
            ICustomerService mapper = getSession().getMapper(ICustomerService.class);
            return mapper.getById(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
        return null;
    }

    @Override
    public void insert(Customer o) {
        try {
            ICustomerService mapper = getSession().getMapper(ICustomerService.class);
            mapper.insert(o);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
    }

    @Override
    public void update(Customer o, int id) {
        try {
            o.setId(id);
            ICustomerService mapper = getSession().getMapper(ICustomerService.class);
            mapper.update(o, id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
    }

    @Override
    public void delete(int id) {
        try {
            ICustomerService mapper = getSession().getMapper(ICustomerService.class);
            mapper.delete(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
    }


    @Override
    public List<Customer> getCustomersByCustomerServiceId(int id) {
        try {
            ICustomerService mapper = getSession().getMapper(ICustomerService.class);
            return mapper.getCustomersByCustomerServiceId(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
        return null;
    }
}
