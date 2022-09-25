package com.solvd.mybatis.service.services.mappers;

import com.solvd.mvc.tables.Customer;
import com.solvd.mvc.tables.CustomerService;

import java.util.List;

public interface ICustomerServiceMapper extends IBaseMapper<CustomerService> {
    List<CustomerService> getCustomerServicesByLocation(String location);
}
