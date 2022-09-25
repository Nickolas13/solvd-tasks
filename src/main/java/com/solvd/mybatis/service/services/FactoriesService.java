package com.solvd.mybatis.service.services;

import com.solvd.mvc.dao.mysql.CustomerServiceDao;
import com.solvd.mvc.tables.Factories;
import com.solvd.mybatis.service.interfaces.IFactoriesService;
import com.solvd.mybatis.service.interfaces.IFactoriesService;
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
        try {
            IFactoriesService mapper = getSession().getMapper(IFactoriesService.class);
            return mapper.getById(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
        return null;
    }

    @Override
    public void insert(Factories o) {
        try {
            IFactoriesService mapper = getSession().getMapper(IFactoriesService.class);
            mapper.insert(o);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
    }

    @Override
    public void update(Factories o, int id) {
        try {
            o.setId(id);
            IFactoriesService mapper = getSession().getMapper(IFactoriesService.class);
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
            IFactoriesService mapper = getSession().getMapper(IFactoriesService.class);
            mapper.delete(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
    }


    @Override
    public List<Factories> getFactoriesByCompanyId(int companyId) {
        try {
            IFactoriesService mapper = getSession().getMapper(IFactoriesService.class);
            return mapper.getFactoriesByCompanyId(companyId);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
        return null;
    }
}
