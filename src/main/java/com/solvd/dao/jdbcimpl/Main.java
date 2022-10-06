package com.solvd.dao.jdbcimpl;

import com.solvd.dao.models.Company;

public class Main {
    //update updates in jdbc impl
    public static void main(String[] args) {
        CompanyDao dao = new CompanyDao();
        Company company = dao.getById(1);
        company.setName("bob");
        company.setLocation("georgia");

    }
}
