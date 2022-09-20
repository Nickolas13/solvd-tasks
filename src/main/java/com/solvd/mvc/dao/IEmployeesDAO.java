package com.solvd.mvc.dao;

import com.solvd.mvc.tables.Employees;

public interface IEmployeesDAO extends IBaseDAO<Employees> {
    Employees getEmployeesByCompanyId(int companyId);
}
