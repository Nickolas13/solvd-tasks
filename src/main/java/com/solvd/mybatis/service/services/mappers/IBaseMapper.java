package com.solvd.mybatis.service.services.mappers;

public interface IBaseMapper<T> {
    T getById(int id);

    void insert(T o);

    void update(T o);

    void delete(int id);
}
