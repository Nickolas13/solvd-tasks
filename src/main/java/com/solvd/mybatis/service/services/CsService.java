package com.solvd.mybatis.service.services;

import com.solvd.mvc.dao.mysql.CustomerServiceDao;
import com.solvd.mvc.tables.CustomerService;
import com.solvd.mybatis.service.interfaces.ICsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static com.solvd.mybatis.service.MyBatis.close;
import static com.solvd.mybatis.service.MyBatis.getSession;

public class CsService implements ICsService {
    private static final Logger logger = LogManager.getLogger(CustomerServiceDao.class);

    @Override
    public CustomerService getById(int id) {
        try {
            ICsService mapper = getSession().getMapper(ICsService.class);
            return mapper.getById(id);
        } finally {
            close(getSession());
        }

    }

    @Override
    public void insert(CustomerService o) {
        try {
            ICsService mapper = getSession().getMapper(ICsService.class);
            mapper.insert(o);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
    }

    @Override
    public void update(CustomerService o, int id) {
        try {
            o.setId(id);
            ICsService mapper = getSession().getMapper(ICsService.class);
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
            ICsService mapper = getSession().getMapper(ICsService.class);
            mapper.delete(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
    }


    @Override
    public List<CustomerService> getCustomerServicesByLocation(String location) {
        try {
            ICsService mapper = getSession().getMapper(ICsService.class);
            return mapper.getCustomerServicesByLocation(location);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(getSession());
        }
        return null;
    }
}
