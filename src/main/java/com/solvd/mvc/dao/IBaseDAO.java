package com.solvd.mvc.dao;

import java.sql.SQLException;

public interface IBaseDAO<T> {
    void create(T object);

    T getById(int id);

    void remove(int id) throws SQLException;

    void update(T object, String target);
}
