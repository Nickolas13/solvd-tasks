package com.solvd.mybatis.service.services;

import com.solvd.mvc.dao.mysql.CustomerServiceDao;
import com.solvd.mvc.tables.Company;
import com.solvd.mybatis.service.interfaces.ICompanyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static com.solvd.mybatis.service.MyBatis.close;
import static com.solvd.mybatis.service.MyBatis.getSession;

public class CompanyService implements ICompanyService {
    private static final Logger logger = LogManager.getLogger(CustomerServiceDao.class);

    @Override
    public List<Company> getCompaniesByLocation(String location) {
        try {
            ICompanyService mapper = getSession().getMapper(ICompanyService.class);
            return mapper.getCompaniesByLocation(location);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
        return null;
    }

    @Override
    public Company getById(int id) {
        try {
            ICompanyService mapper = getSession().getMapper(ICompanyService.class);
            return mapper.getById(id);
        } finally {
            close(getSession());
        }

    }

    @Override
    public void insert(Company o) {
        try {
            ICompanyService mapper = getSession().getMapper(ICompanyService.class);
            mapper.insert(o);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
    }

    @Override
    public void update(Company o, int id) {
        try {
            o.setId(id);
            ICompanyService mapper = getSession().getMapper(ICompanyService.class);
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
            ICompanyService mapper = getSession().getMapper(ICompanyService.class);
            mapper.delete(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
    }
}
