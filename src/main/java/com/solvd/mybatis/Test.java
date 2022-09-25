package com.solvd.mybatis;

import com.solvd.mvc.tables.*;
import com.solvd.mybatis.service.services.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {
    private static final Logger logger = LogManager.getLogger(Test.class);
    public static void main(String[] args) {

        CompanyService service = new CompanyService();
        Company company = new Company("warners", "amsterdam", "9879879", "warners@gmail.com");
        service.update(company, 2);


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
