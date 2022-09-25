package com.solvd.mybatis.service.services;

import com.solvd.mvc.dao.mysql.CustomerServiceDao;
import com.solvd.mvc.tables.Customer;
import com.solvd.mybatis.service.interfaces.ICustomerService;
import com.solvd.mybatis.service.services.mappers.ICustomerMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static com.solvd.mybatis.service.MyBatis.close;
import static com.solvd.mybatis.service.MyBatis.getSession;

public class CustomersService implements ICustomerService {
    private static final Logger logger = LogManager.getLogger(CustomerServiceDao.class);

    @Override
    public Customer getById(int id) {
        SqlSession session = getSession();
        try {
            ICustomerMapper mapper = session.getMapper(ICustomerMapper.class);
            return mapper.getById(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(session);
        }
        return null;
    }

    @Override
    public void insert(Customer o) {
        SqlSession session = getSession();
        try {
            ICustomerMapper mapper = session.getMapper(ICustomerMapper.class);
            mapper.insert(o);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(session);
        }
    }

    @Override
    public void update(Customer o, int id) {
        SqlSession session = getSession();
        try {
            o.setId(id);
            ICustomerMapper mapper = session.getMapper(ICustomerMapper.class);
            mapper.update(o);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(session);
        }
    }

    @Override
    public void delete(int id) {
        SqlSession session = getSession();
        try {
            ICustomerMapper mapper = session.getMapper(ICustomerMapper.class);
            mapper.delete(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(session);
        }
    }


    @Override
    public List<Customer> getCustomersByCustomerServiceId(int id) {
        SqlSession session = getSession();
        try {
            ICustomerMapper mapper = session.getMapper(ICustomerMapper.class);
            return mapper.getCustomersByCustomerServiceId(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(session);
        }
        return null;
    }
}
