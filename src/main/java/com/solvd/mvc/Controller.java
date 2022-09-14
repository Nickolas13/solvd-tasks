package com.solvd.mvc;


import com.solvd.mvc.dao.mysql.CompanyDao;
import com.solvd.mvc.tables.Company;

import java.sql.SQLException;

public class Controller {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CompanyDao dao = new CompanyDao();
//        dao.getById(5);
//
//        //remove by id
//        dao.remove(3);
//        //update element
//        dao.update(new Company(3, "billy", "fuji", "6546556", "everest@gmail.com"), "location");
//        dao.getById(3);
        dao.create(new Company("nasda", "asdas", "asdas", "asdsa@gmail.com"));

    }
}
