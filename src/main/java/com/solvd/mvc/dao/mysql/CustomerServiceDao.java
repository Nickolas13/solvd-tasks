package com.solvd.mvc.dao.mysql;

import com.solvd.mvc.dao.IBaseDao;
import com.solvd.mvc.tables.CustomerService;

public class CustomerServiceDao extends MySqlDao implements IBaseDao<CustomerService> {
    @Override
    public void create(CustomerService object) {

    }

    @Override
    public CustomerService getById(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public void update(CustomerService object, String target) {

    }
}
