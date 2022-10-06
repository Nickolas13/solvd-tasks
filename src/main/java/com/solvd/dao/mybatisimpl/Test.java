package com.solvd.dao.mybatisimpl;

import com.solvd.dao.models.Customer;
import com.solvd.dao.models.CustomerService;
import com.solvd.dao.models.Employees;
import com.solvd.dao.models.Factories;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {
    private static final Logger logger = LogManager.getLogger(Test.class);
    public static void main(String[] args) {

//        CompanyService service = new CompanyService();
//        Company company = new Company("example", "example", "9879879", "warners@gmail.com");
//        service.update(company, 2);
//        service.delete(2);
//        service.insert(new Company("something","smth","6545646","smth@gmail.com"));


        FactoriesDao service2 = new FactoriesDao();
        Factories factory = service2.getById(2);
        System.out.println(factory);

        //customer service's service class
        CustomerServiceDao cservice = new CustomerServiceDao();
        CustomerService customerService = cservice.getById(3);
        System.out.println(customerService);
        customerService.setLocation("Georgia");
        System.out.println(customerService);

        EmployeesDao empService = new EmployeesDao();
        Employees employee = empService.getById(3);
        System.out.println(employee);

        CustomerDao customersService = new CustomerDao();
        Customer customer = customersService.getById(4);
        System.out.println(customer);


    }
}
