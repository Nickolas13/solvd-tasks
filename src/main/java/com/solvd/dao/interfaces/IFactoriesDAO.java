package com.solvd.dao.interfaces;

import com.solvd.dao.models.Factories;

import java.util.List;

public interface IFactoriesDAO extends IBaseDAO<Factories> {
    public List<Factories> getFactoriesByCompanyId(int companyId);
}
