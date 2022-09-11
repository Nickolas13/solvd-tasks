package com.solvd.mvc;


import com.solvd.mvc.tables.Company;

import java.sql.SQLException;

public class Controller {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Services service = new Services();
        service.getCompanyById(5);

        service.creatCompany(new Company(5, "DropShip", "Sweden", "7854156", "solvd@gmail.com"));
    }
}
