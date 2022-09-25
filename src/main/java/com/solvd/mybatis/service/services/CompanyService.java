package com.solvd.mybatis.service.services;

import com.solvd.mvc.dao.mysql.CustomerServiceDao;
import com.solvd.mvc.tables.Company;

import com.solvd.mybatis.service.interfaces.ICompanyService;

import com.solvd.mybatis.service.services.mappers.ICompanyMapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.solvd.mybatis.service.MyBatis.close;
import static com.solvd.mybatis.service.MyBatis.getSession;

import java.util.List;


public class CompanyService implements ICompanyService {
    private static final Logger logger = LogManager.getLogger(CustomerServiceDao.class);

    @Override
    public Company getById(int id) {
        SqlSession session = getSession();
        try {
            ICompanyMapper mapper = session.getMapper(ICompanyMapper.class);
            return mapper.getById(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(session);
        }
        return null;
    }

    @Override
    public void insert(Company o) {
        SqlSession session = getSession();
        try {
            ICompanyMapper mapper = session.getMapper(ICompanyMapper.class);
            mapper.insert(o);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(session);
        }
    }

    @Override
    public void update(Company o, int id) {
        SqlSession session = getSession();
        try {
            o.setId(id);
            ICompanyMapper mapper = session.getMapper(ICompanyMapper.class);
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
            ICompanyMapper mapper = session.getMapper(ICompanyMapper.class);
            mapper.delete(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(session);
        }
    }

    @Override
    public List<Company> getCompaniesByLocation(String location) {
        SqlSession session = getSession();
        try {
            ICompanyMapper mapper = session.getMapper(ICompanyMapper.class);
            return mapper.getCompaniesByLocation(location);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(session);
        }
        return null;
    }
}
