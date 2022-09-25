package com.solvd.mybatis.service.interfaces;

import com.solvd.mvc.dao.IBaseDAO;
import com.solvd.mvc.tables.Company;

import java.util.List;

public interface ICompanyService extends IBase<Company> {
    List<Company> getCompaniesByLocation(String location);
}
