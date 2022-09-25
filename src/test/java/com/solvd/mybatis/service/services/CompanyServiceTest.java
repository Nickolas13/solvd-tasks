package com.solvd.mybatis.service.services;

import com.solvd.mvc.tables.Company;
import com.solvd.mybatis.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyServiceTest {

    @Test
    void getCompaniesByLocation() {
    }

    @Test
    void getById() {
        CompanyService service = new CompanyService();
        Company student = service.getById(2);
        System.out.println(student);
    }

    @Test
    void insert() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}