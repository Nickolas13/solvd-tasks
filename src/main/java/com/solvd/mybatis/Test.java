package com.solvd.mybatis;

import com.solvd.mvc.tables.Company;
import com.solvd.mvc.tables.CustomerService;
import com.solvd.mvc.tables.Factories;
import com.solvd.mybatis.service.services.CompanyService;
import com.solvd.mybatis.service.services.CsService;
import com.solvd.mybatis.service.services.FactoriesService;
import com.solvd.mybatis.service.services.StudentService;

public class Test {
    public static void main(String[] args) {

//        CompanyService service = new CompanyService();
//        Company company = service.getById(2);
//        System.out.println(company);
//
//        FactoriesService service2 = new FactoriesService();
//        Factories factory = service2.getById(2);
//        System.out.println(factory);

        CsService service = new CsService();
        CustomerService customerService = service.getById(2);
        System.out.println(customerService);
    }
}
