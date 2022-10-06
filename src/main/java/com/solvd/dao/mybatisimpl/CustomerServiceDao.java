package com.solvd.dao.mybatisimpl;

import com.solvd.dao.interfaces.IBaseDAO;
import com.solvd.dao.interfaces.ICustomerServiceDAO;
import com.solvd.dao.models.CustomerService;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CustomerServiceDao implements IBaseDAO<CustomerService>, ICustomerServiceDAO {
    private static final Logger logger = LogManager.getLogger(com.solvd.dao.jdbcimpl.CustomerServiceDao.class);

    @Override
    public CustomerService getById(int id) {
        SqlSession session = MyBatis.getSession();
        try {
            ICustomerServiceDAO mapper = session.getMapper(ICustomerServiceDAO.class);
            return mapper.getById(id);
        } finally {
            MyBatis.close(session);
        }

    }

    @Override
    public void insert(CustomerService o) {
        SqlSession session = MyBatis.getSession();
        try {
            ICustomerServiceDAO mapper = session.getMapper(ICustomerServiceDAO.class);
            mapper.insert(o);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
    }

    @Override
    public void update(CustomerService o) {
        SqlSession session = MyBatis.getSession();
        try {
            ICustomerServiceDAO mapper = session.getMapper(ICustomerServiceDAO.class);
            mapper.update(o);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
    }

    @Override
    public void delete(int id) {
        SqlSession session = MyBatis.getSession();
        try {
            ICustomerServiceDAO mapper = session.getMapper(ICustomerServiceDAO.class);
            mapper.delete(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
    }


    @Override
    public List<CustomerService> getCustomerServicesByLocation(String location) {
        SqlSession session = MyBatis.getSession();
        try {
            ICustomerServiceDAO mapper = session.getMapper(ICustomerServiceDAO.class);
            return mapper.getCustomerServicesByLocation(location);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
        return null;
    }
}
