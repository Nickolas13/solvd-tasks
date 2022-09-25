package com.solvd.mybatis.service.services;

import com.solvd.mvc.dao.mysql.CustomerServiceDao;
import com.solvd.mvc.tables.Employees;
import com.solvd.mybatis.service.interfaces.IEmployeesService;
import com.solvd.mybatis.service.services.mappers.IEmployeesMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static com.solvd.mybatis.service.MyBatis.close;
import static com.solvd.mybatis.service.MyBatis.getSession;

public class EmployeesService implements IEmployeesService {
    private static final Logger logger = LogManager.getLogger(CustomerServiceDao.class);


    @Override
    public Employees getById(int id) {
        try {
            IEmployeesMapper mapper = getSession().getMapper(IEmployeesMapper.class);
            return mapper.getById(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
        return null;
    }

    @Override
    public void insert(Employees o) {
        try {
            IEmployeesMapper mapper = getSession().getMapper(IEmployeesMapper.class);
            mapper.insert(o);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
    }

    @Override
    public void update(Employees o, int id) {
        SqlSession session = getSession();
        try {
            o.setId(id);
            IEmployeesMapper mapper = session.getMapper(IEmployeesMapper.class);
            mapper.update(o);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
    }

    @Override
    public void delete(int id) {
        SqlSession session = getSession();
        try {
            IEmployeesMapper mapper = session.getMapper(IEmployeesMapper.class);
            mapper.delete(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
    }


    @Override
    public List<Employees> getEmployeesByCompanyId(int id) {
        SqlSession session = getSession();
        try {
            IEmployeesMapper mapper = session.getMapper(IEmployeesMapper.class);
            return mapper.getEmployeesByCompanyId(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
        return null;
    }

    @Override
    public List<Employees> getEmployeesByFactoryId(int id) {
        SqlSession session = getSession();
        try {
            IEmployeesMapper mapper = session.getMapper(IEmployeesMapper.class);
            return mapper.getEmployeesByFactoryId(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
        return null;
    }

    @Override
    public List<Employees> getEmployeesByCustomerServiceId(int id) {
        SqlSession session = getSession();
        try {
            IEmployeesMapper mapper = session.getMapper(IEmployeesMapper.class);
            return mapper.getEmployeesByCustomerServiceId(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
        return null;
    }
}
