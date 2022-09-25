package com.solvd.mybatis.service.services.mappers;

import com.solvd.mvc.tables.Factories;

import java.util.List;

public interface IFactoriesMapper extends IBaseMapper<Factories> {
    List<Factories> getFactoriesByCompanyId(int id);
}
