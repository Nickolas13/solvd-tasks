package com.solvd.mybatis;

import com.solvd.mvc.tables.*;
import com.solvd.mybatis.service.services.*;

public class Test {
    public static void main(String[] args) {

        CompanyService service = new CompanyService();
        Company company = service.getById(2);
        System.out.println(company);

        FactoriesService service2 = new FactoriesService();
        Factories factory = service2.getById(2);
        System.out.println(factory);

        CsService cservice = new CsService();
        CustomerService customerService = cservice.getById(2);
        System.out.println(customerService);

        EmployeesService empService = new EmployeesService();
        Employees employee = empService.getById(3);
        System.out.println(employee);

        CustomersService customersService = new CustomersService();
        Customer customer = customersService.getById(4);
        System.out.println(customer);

    }
}
