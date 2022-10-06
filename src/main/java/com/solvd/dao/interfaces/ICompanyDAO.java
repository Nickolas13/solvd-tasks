package com.solvd.dao.interfaces;


import com.solvd.dao.models.Company;

public interface ICompanyDAO extends IBaseDAO<Company> {
    Company getCompaniesByLocation(String Location);

}
