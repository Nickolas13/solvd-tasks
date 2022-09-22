package com.solvd.mybatis;

public interface IDAO<T> {
    void create(T t);

    T getById(long id);
}
