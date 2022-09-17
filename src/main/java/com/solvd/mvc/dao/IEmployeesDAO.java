package com.solvd.mvc.dao;

import com.solvd.mvc.tables.Employees;

public interface IEmployeesDAO extends IBaseDAO<Employees> {
    void getEmployeesByCompanyId(int company_id);
}
