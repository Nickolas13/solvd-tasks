package com.solvd.mybatis.service.services;

import com.solvd.mvc.dao.mysql.CustomerServiceDao;
import com.solvd.mvc.tables.Employees;
import com.solvd.mybatis.service.interfaces.IEmployeesService;
import com.solvd.mybatis.service.interfaces.IEmployeesService;
import com.solvd.mybatis.service.interfaces.IEmployeesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

import static com.solvd.mybatis.service.MyBatis.close;
import static com.solvd.mybatis.service.MyBatis.getSession;

public class EmployeesService implements IEmployeesService {
    private static final Logger logger = LogManager.getLogger(CustomerServiceDao.class);


    @Override
    public Employees getById(int id) {
        try {
            IEmployeesService mapper = getSession().getMapper(IEmployeesService.class);
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
            IEmployeesService mapper = getSession().getMapper(IEmployeesService.class);
            mapper.insert(o);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
    }

    @Override
    public void update(Employees o, int id) {
        try {
            o.setId(id);
            IEmployeesService mapper = getSession().getMapper(IEmployeesService.class);
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
            IEmployeesService mapper = getSession().getMapper(IEmployeesService.class);
            mapper.delete(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
    }


    @Override
    public List<Employees> getEmployeesByCompanyId(int id) {
        try {
            IEmployeesService mapper = getSession().getMapper(IEmployeesService.class);
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
        try {
            IEmployeesService mapper = getSession().getMapper(IEmployeesService.class);
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
        try {
            IEmployeesService mapper = getSession().getMapper(IEmployeesService.class);
            return mapper.getEmployeesByCustomerServiceId(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
        return null;
    }
}
