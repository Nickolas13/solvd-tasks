package com.solvd.mybatis.service.services;

import com.solvd.mvc.dao.mysql.CustomerServiceDao;
import com.solvd.mvc.tables.Factories;
import com.solvd.mybatis.service.interfaces.IFactoriesService;
import com.solvd.mybatis.service.services.mappers.IFactoriesMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

import static com.solvd.mybatis.service.MyBatis.close;
import static com.solvd.mybatis.service.MyBatis.getSession;

public class FactoriesService implements IFactoriesService {
    private static final Logger logger = LogManager.getLogger(CustomerServiceDao.class);


    @Override
    public Factories getById(int id) {
        SqlSession session = getSession();
        try {
            IFactoriesMapper mapper = session.getMapper(IFactoriesMapper.class);
            return mapper.getById(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(session);
        }
        return null;
    }

    @Override
    public void insert(Factories o) {
        SqlSession session = getSession();
        try {
            IFactoriesMapper mapper = session.getMapper(IFactoriesMapper.class);
            mapper.insert(o);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(session);
        }
    }

    @Override
    public void update(Factories o, int id) {
        SqlSession session = getSession();
        try {
            o.setId(id);
            IFactoriesMapper mapper = session.getMapper(IFactoriesMapper.class);
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
            IFactoriesMapper mapper = session.getMapper(IFactoriesMapper.class);
            mapper.delete(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(session);
        }
    }


    @Override
    public List<Factories> getFactoriesByCompanyId(int companyId) {
        SqlSession session = getSession();
        try {
            IFactoriesMapper mapper = session.getMapper(IFactoriesMapper.class);
            return mapper.getFactoriesByCompanyId(companyId);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(session);
        }
        return null;
    }
}
