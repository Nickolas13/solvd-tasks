package com.solvd.mybatis.service.interfaces;

public interface IBase<T> {
    T getById(int id);

    void insert(T o);

    void update(T o, int id);

    void delete(int id);
}
