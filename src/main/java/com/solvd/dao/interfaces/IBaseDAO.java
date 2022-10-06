package com.solvd.dao.interfaces;

import com.solvd.dao.models.Customer;

import java.sql.SQLException;

public interface IBaseDAO<T> {
    void insert(T object);

    T getById(int id);

    void delete(int id);

    void update(T object);

}
