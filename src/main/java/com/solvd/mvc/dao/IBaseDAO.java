package com.solvd.mvc.dao;

import com.solvd.mvc.tables.Company;

import java.sql.SQLException;

public interface IBaseDAO {
    Company getById(int id) throws ClassNotFoundException, SQLException;

    void create(Company com) throws SQLException;

    void remove(int id);

    void update(Company com);
}
