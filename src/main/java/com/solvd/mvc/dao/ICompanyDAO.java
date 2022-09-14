package com.solvd.mvc.dao;


import com.solvd.mvc.tables.Company;

public interface ICompanyDAO extends IBaseDao<Company> {
    void getFactories();

}
