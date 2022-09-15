package com.solvd.mvc.dao;

import com.solvd.mvc.tables.Customer;


public interface ICustomerDAO extends IBaseDAO<Customer> {

    Customer getCustomersByCsId(int id);
}
