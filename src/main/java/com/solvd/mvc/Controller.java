package com.solvd.mvc;


import com.solvd.mvc.tables.Company;

import java.sql.SQLException;

public class Controller {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Services service = new Services();
        //select by id
        service.getCompanyById(5);

        //insert new element
    }
}
