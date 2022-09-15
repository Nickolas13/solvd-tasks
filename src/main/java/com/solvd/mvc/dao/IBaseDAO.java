package com.solvd.mvc.dao;

public interface IBaseDAO<T> {
    void create(T object);

    T getById(int id);

    void remove(int id);

    void update(T object, String target);
}
