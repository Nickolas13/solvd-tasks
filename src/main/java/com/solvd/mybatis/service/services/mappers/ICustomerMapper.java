package com.solvd.mybatis.service.services.mappers;

import com.solvd.mvc.tables.Customer;

import java.util.List;

public interface ICustomerMapper extends IBaseMapper<Customer> {
    List<Customer> getCustomersByCustomerServiceId(int id);
}
