package com.solvd.dao.mybatisimpl;

import com.solvd.dao.interfaces.ICompanyDAO;
import com.solvd.dao.interfaces.ICompanyDAO;
import com.solvd.dao.jdbcimpl.CustomerServiceDao;
import com.solvd.dao.models.Company;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class CompanyDao implements ICompanyDAO {
    private static final Logger logger = LogManager.getLogger(CustomerServiceDao.class);

    @Override
    public Company getById(int id) {
        SqlSession session = MyBatis.getSession();
        try {
            ICompanyDAO mapper = session.getMapper(ICompanyDAO.class);
            return mapper.getById(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
        return null;
    }

    @Override
    public void insert(Company company) {
        SqlSession session = MyBatis.getSession();
        try {
            ICompanyDAO mapper = session.getMapper(ICompanyDAO.class);
            mapper.insert(company);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
    }

    @Override
    public void update(Company company) {
        SqlSession session = MyBatis.getSession();
        try {
            ICompanyDAO mapper = session.getMapper(ICompanyDAO.class);
            mapper.update(company);
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
            ICompanyDAO mapper = session.getMapper(ICompanyDAO.class);
            mapper.delete(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
    }

    @Override
    public Company getCompaniesByLocation(String location) {
        SqlSession session = MyBatis.getSession();
        try {
            ICompanyDAO mapper = session.getMapper(ICompanyDAO.class);
            return mapper.getCompaniesByLocation(location);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
        return null;
    }
}
