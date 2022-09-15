package com.solvd.mvc;


import com.solvd.mvc.dao.mysql.*;
import com.solvd.mvc.tables.*;

import java.sql.SQLException;

public class Controller {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CompanyDao company = new CompanyDao();
        CustomerDao customer = new CustomerDao();
        CustomerServiceDao cs = new CustomerServiceDao();
        EmployeesDao employee = new EmployeesDao();
        FactoriesDao factory = new FactoriesDao();

//
//        //Create Elements
//        company.create(new Company("comp", "mars", 4564787, "asdsa@gmail.com"));
//        customer.create(new Customer("bob", "smith", "new york", 645646, "smith@gmail.com", 2));
//        cs.create(new CustomerService("new zealand", "thursday", "friday"));
//        employee.create(new Employees("will", "lenon", "lenon@gmail.com", 1, 2, 3));
//        factory.create(new Factories("clothing", "suits", 30000, 2));
//
//
//        //update elements
//        company.update(new Company("billy", "fuji", 5646546, "everest@gmail.com"), "location");
//        customer.update(new Customer("bob", "smith", "new york", 645646, "smith@gmail.com", 2), "phone");
//
//        //customer service update
//        cs.update(new CustomerService("new zealand", "thursday", "friday"), "work_from");
//        employee.update(new Employees("will", "lenon", "lenon@gmail.com", 1, 2, 3), "lastname");
//        factory.update(new Factories("clothing", "suits", 30000, 2), "pa_month");//pa_month is production amount per month
//
//
//        //Get Elements By Id
//        company.getById(5);
//        customer.getById(3);
//        cs.getById(2);
//        employee.getById(4);
//        factory.getById(1);

        //Get Customers By Customer Service ID
        customer.getCustomersByCsId(5);


        //Remove Elements By Id
//        customer.remove(5);
//        employee.remove(3);


    }
}
