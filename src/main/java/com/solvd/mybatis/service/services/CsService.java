package com.solvd.mybatis.service.services;

import com.solvd.mvc.dao.mysql.CustomerServiceDao;
import com.solvd.mvc.tables.CustomerService;
import com.solvd.mybatis.service.interfaces.ICsService;
import com.solvd.mybatis.service.services.mappers.ICustomerServiceMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static com.solvd.mybatis.service.MyBatis.close;
import static com.solvd.mybatis.service.MyBatis.getSession;

public class CsService implements ICsService {
    private static final Logger logger = LogManager.getLogger(CustomerServiceDao.class);

    @Override
    public CustomerService getById(int id) {
        SqlSession session = getSession();
        try {
            ICustomerServiceMapper mapper = session.getMapper(ICustomerServiceMapper.class);
            return mapper.getById(id);
        } finally {
            close(session);
        }

    }

    @Override
    public void insert(CustomerService o) {
        SqlSession session = getSession();
        try {
            ICustomerServiceMapper mapper = session.getMapper(ICustomerServiceMapper.class);
            mapper.insert(o);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(session);
        }
    }

    @Override
    public void update(CustomerService o, int id) {
        SqlSession session = getSession();
        try {
            o.setId(id);
            ICustomerServiceMapper mapper = session.getMapper(ICustomerServiceMapper.class);
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
            ICustomerServiceMapper mapper = session.getMapper(ICustomerServiceMapper.class);
            mapper.delete(id);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(session);
        }
    }


    @Override
    public List<CustomerService> getCustomerServicesByLocation(String location) {
        SqlSession session = getSession();
        try {
            ICustomerServiceMapper mapper = session.getMapper(ICustomerServiceMapper.class);
            return mapper.getCustomerServicesByLocation(location);
        } catch (Exception e) {
            logger.error(e);
        } finally {
            close(session);
        }
        return null;
    }
}
