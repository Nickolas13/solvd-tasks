package com.solvd.mvc;


import com.solvd.mvc.tables.Company;

import java.sql.SQLException;

public class Controller {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Services service = new Services();
        //select by id
//        service.getCompanyById(5);
//
//        //remove by id
//        service.removeCompany(3);

        //insert new element
        service.getCompanyById(3);
        //update element
        service.updateCompany(new Company(3, "billy", "fuji", "6546556", "everest@gmail.com"), "location");
        service.getCompanyById(3);
    }
}
