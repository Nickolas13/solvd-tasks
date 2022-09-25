package com.solvd.mybatis.service.services.mappers;

import com.solvd.mvc.tables.Company;

import java.util.List;

public interface ICompanyMapper extends IBaseMapper<Company> {
    List<Company> getCompaniesByLocation(String location);
}
