package com.solvd.mybatis.service.interfaces;

import com.solvd.mvc.dao.IBaseDAO;
import com.solvd.mvc.tables.Employees;

import java.util.List;

public interface IEmployeesService extends IBase<Employees> {
    List<Employees> getEmployeesByCompanyId(int id);

    List<Employees> getEmployeesByFactoryId(int id);

    List<Employees> getEmployeesByCustomerServiceId(int id);
}
