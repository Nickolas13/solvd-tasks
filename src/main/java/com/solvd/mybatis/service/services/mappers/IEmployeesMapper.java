package com.solvd.mybatis.service.services.mappers;

import com.solvd.mvc.tables.Employees;

import java.util.List;

public interface IEmployeesMapper extends IBaseMapper<Employees> {
    List<Employees> getEmployeesByCompanyId(int id);

    List<Employees> getEmployeesByFactoryId(int id);

    List<Employees> getEmployeesByCustomerServiceId(int id);
}
