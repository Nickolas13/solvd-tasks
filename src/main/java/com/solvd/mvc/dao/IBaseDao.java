package com.solvd.mvc.dao;

public interface IBaseDao<T> {
    void create(T object);

    T getById(int id);

    void remove(int id);

    void update(T object, String target);
}
