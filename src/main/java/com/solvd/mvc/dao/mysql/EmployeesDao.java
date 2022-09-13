package com.solvd.mvc.dao.mysql;

import com.solvd.mvc.dao.IBaseDao;
import com.solvd.mvc.tables.Employees;

public class EmployeesDao extends MySqlDao implements IBaseDao<Employees> {
    @Override
    public void create(Employees object) {

    }

    @Override
    public Employees getById(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public void update(Employees object, String target) {

    }
}
