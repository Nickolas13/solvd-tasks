package com.solvd.mvc;

import com.solvd.mvc.dao.mysql.CompanyDao;
import com.solvd.mvc.tables.Company;

import javax.naming.CompositeName;
import java.sql.SQLException;

public class Services {
    private static CompanyDao dao = new CompanyDao();

    public Company getCompanyById(int id) throws SQLException, ClassNotFoundException {
        Company com = dao.getById(id);
        return com;
    }

    public void removeCompany(int id) {
        dao.remove(id);
    }

    public void creatCompany(Company com) throws SQLException {
        dao.create(com);
    }

    public void updateCompany() {
//        Company com = new Company("solvd", "Poland", "5465156", "solvd@gmail.com");
//        dao.update(com);
    }


}
