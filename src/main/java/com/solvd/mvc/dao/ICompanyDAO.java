package com.solvd.mvc.dao;

import com.solvd.mvc.tables.Company;

import java.sql.SQLException;

public interface ICompanyDAO extends IBaseDao {
    void getFactories();
}
