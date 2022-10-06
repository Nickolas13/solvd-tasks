package com.solvd.dao.interfaces;

import com.solvd.dao.models.Employees;

public interface IEmployeesDAO extends IBaseDAO<Employees> {
    Employees getEmployeesByCompanyId(int companyId);

    Employees getEmployeesByFactoryId(int id);

    Employees getEmployeesByCustomerServiceId(int id);
}
