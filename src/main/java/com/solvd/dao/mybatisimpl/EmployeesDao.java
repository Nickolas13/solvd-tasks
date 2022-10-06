package com.solvd.dao.mybatisimpl;

import com.solvd.dao.interfaces.IEmployeesDAO;

import com.solvd.dao.jdbcimpl.CustomerServiceDao;
import com.solvd.dao.models.Employees;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmployeesDao implements IEmployeesDAO {
    private static final Logger logger = LogManager.getLogger(CustomerServiceDao.class);


    @Override
    public Employees getById(int id) {
        try {
            IEmployeesDAO mapper = MyBatis.getSession().getMapper(IEmployeesDAO.class);
            return mapper.getById(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(MyBatis.getSession());
        }
        return null;
    }

    @Override
    public void insert(Employees o) {
        try {
            IEmployeesDAO mapper = MyBatis.getSession().getMapper(IEmployeesDAO.class);
            mapper.insert(o);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(MyBatis.getSession());
        }
    }

    @Override
    public void update(Employees o) {
        SqlSession session = MyBatis.getSession();
        try {
            IEmployeesDAO mapper = session.getMapper(IEmployeesDAO.class);
            mapper.update(o);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(MyBatis.getSession());
        }
    }

    @Override
    public void delete(int id) {
        SqlSession session = MyBatis.getSession();
        try {
            IEmployeesDAO mapper = session.getMapper(IEmployeesDAO.class);
            mapper.delete(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(MyBatis.getSession());
        }
    }


    @Override
    public Employees getEmployeesByCompanyId(int id) {
        SqlSession session = MyBatis.getSession();
        try {
            IEmployeesDAO mapper = session.getMapper(IEmployeesDAO.class);
            return mapper.getEmployeesByCompanyId(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(MyBatis.getSession());
        }
        return null;
    }

    @Override
    public Employees getEmployeesByFactoryId(int id) {
        SqlSession session = MyBatis.getSession();
        try {
            IEmployeesDAO mapper = session.getMapper(IEmployeesDAO.class);
            return mapper.getEmployeesByFactoryId(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(MyBatis.getSession());
        }
        return null;
    }

    @Override
    public Employees getEmployeesByCustomerServiceId(int id) {
        SqlSession session = MyBatis.getSession();
        try {
            IEmployeesDAO mapper = session.getMapper(IEmployeesDAO.class);
            return mapper.getEmployeesByCustomerServiceId(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(MyBatis.getSession());
        }
        return null;
    }
}
