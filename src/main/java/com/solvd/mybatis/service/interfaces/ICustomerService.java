package com.solvd.mybatis.service.interfaces;

import com.solvd.mvc.dao.IBaseDAO;
import com.solvd.mvc.tables.Customer;

import java.util.List;

public interface ICustomerService extends IBase<Customer> {
    List<Customer> getCustomersByCustomerServiceId(int id);
}
