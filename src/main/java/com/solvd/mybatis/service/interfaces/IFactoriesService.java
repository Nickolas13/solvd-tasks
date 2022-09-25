package com.solvd.mybatis.service.interfaces;

import com.solvd.mvc.dao.IBaseDAO;
import com.solvd.mvc.tables.Factories;

import java.util.List;

public interface IFactoriesService extends IBase<Factories> {
    List<Factories> getFactoriesByCompanyId(int companyId);
}
