package com.solvd.mybatis.service.interfaces;

import com.solvd.mvc.dao.IBaseDAO;
import com.solvd.mvc.tables.CustomerService;

import java.util.List;

public interface ICsService extends IBase<CustomerService> {
    List<CustomerService> getCustomerServicesByLocation(String location);
}
