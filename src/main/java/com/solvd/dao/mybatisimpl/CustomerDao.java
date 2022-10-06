package com.solvd.dao.mybatisimpl;

import com.solvd.dao.interfaces.IBaseDAO;
import com.solvd.dao.interfaces.ICustomerDAO;
import com.solvd.dao.jdbcimpl.CustomerServiceDao;
import com.solvd.dao.models.Customer;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CustomerDao implements IBaseDAO<Customer>, ICustomerDAO {
    private static final Logger logger = LogManager.getLogger(CustomerServiceDao.class);

    @Override
    public Customer getById(int id) {
        SqlSession session = MyBatis.getSession();
        try {
            ICustomerDAO mapper = session.getMapper(ICustomerDAO.class);
            return mapper.getById(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
        return null;
    }

    @Override
    public void insert(Customer o) {
        SqlSession session = MyBatis.getSession();
        try {
            ICustomerDAO mapper = session.getMapper(ICustomerDAO.class);
            mapper.insert(o);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
    }

    @Override
    public void update(Customer o) {
        SqlSession session = MyBatis.getSession();
        try {
            ICustomerDAO mapper = session.getMapper(ICustomerDAO.class);
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
            ICustomerDAO mapper = session.getMapper(ICustomerDAO.class);
            mapper.delete(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
    }


    @Override
    public Customer getCustomersByCustomerServiceId(int id) {
        SqlSession session = MyBatis.getSession();
        try {
            ICustomerDAO mapper = session.getMapper(ICustomerDAO.class);
            return mapper.getCustomersByCustomerServiceId(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
        return null;
    }
}
