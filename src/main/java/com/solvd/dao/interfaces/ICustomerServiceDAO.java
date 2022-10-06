package com.solvd.dao.interfaces;

import com.solvd.dao.models.CustomerService;

import java.util.List;

public interface ICustomerServiceDAO extends IBaseDAO<CustomerService> {
    List<CustomerService> getCustomerServicesByLocation(String location);
}
