package com.solvd.mvc.dao.mysql;

import com.solvd.mvc.dao.IBaseDao;
import com.solvd.mvc.tables.Customer;

public class CustomerDao extends MySqlDao implements IBaseDao<Customer> {
    @Override
    public void create(Customer object) {

    }

    @Override
    public Customer getById(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public void update(Customer object) {

    }
}
