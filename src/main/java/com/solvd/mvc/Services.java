package com.solvd.mvc;

import com.solvd.mvc.dao.mysql.CompanyDao;
import com.solvd.mvc.tables.Company;

import javax.naming.CompositeName;
import java.sql.SQLException;

public class Services {
    private static CompanyDao dao = new CompanyDao();

    public Company getCompanyById(int id) throws SQLException {
        Company com = dao.getById(id);
        return com;
    }


    public void creatCompany(Company com) throws SQLException {
        dao.create(com);
    }

    public void removeCompany(int id) {
        dao.remove(id);
    }

    public void updateCompany() {
        Company com = new Company(6, "solvd", "Poland", "5465156", "solvd@gmail.com");
        dao.update(com);
    }


}
