package com.solvd.dao.interfaces;

import com.solvd.dao.models.Customer;

import java.util.List;


public interface ICustomerDAO extends IBaseDAO<Customer> {

    Customer getCustomersByCustomerServiceId(int id);
}
