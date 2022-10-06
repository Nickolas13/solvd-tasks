package com.solvd.dao.mybatisimpl;

import com.solvd.dao.interfaces.IBaseDAO;
import com.solvd.dao.interfaces.IFactoriesDAO;
import com.solvd.dao.interfaces.IFactoriesDAO;
import com.solvd.dao.jdbcimpl.CustomerServiceDao;
import com.solvd.dao.models.Factories;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class FactoriesDao implements IBaseDAO<Factories>, IFactoriesDAO {
    private static final Logger logger = LogManager.getLogger(CustomerServiceDao.class);


    @Override
    public Factories getById(int id) {
        SqlSession session = MyBatis.getSession();
        try {
            IFactoriesDAO mapper = session.getMapper(IFactoriesDAO.class);
            return mapper.getById(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
        return null;
    }

    @Override
    public void insert(Factories o) {
        SqlSession session = MyBatis.getSession();
        try {
            IFactoriesDAO mapper = session.getMapper(IFactoriesDAO.class);
            mapper.insert(o);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
    }

    @Override
    public void update(Factories o) {
        SqlSession session = MyBatis.getSession();
        try {
            IFactoriesDAO mapper = session.getMapper(IFactoriesDAO.class);
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
            IFactoriesDAO mapper = session.getMapper(IFactoriesDAO.class);
            mapper.delete(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
    }


    @Override
    public List<Factories> getFactoriesByCompanyId(int companyId) {
        SqlSession session = MyBatis.getSession();
        try {
            IFactoriesDAO mapper = session.getMapper(IFactoriesDAO.class);
            return mapper.getFactoriesByCompanyId(companyId);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            MyBatis.close(session);
        }
        return null;
    }
}
