package com.solvd.mybatis.service.services;

import com.solvd.mvc.tables.Company;
import org.junit.jupiter.api.Test;

class CompanyServiceTest {
    static CompanyService service = new CompanyService();
    @Test
    void getCompaniesByLocation() {
    }

    @Test
    void getById() {
        Company company = service.getById(2);
        System.out.println(company);
    }

    @Test
    void insert() {
        service.insert(new Company("Disney", "earth", "65465", "disney@gmail.com"));
    }

    @Test
    void update() {
        service.update(new Company("asdasd", "asdasd", "897945", "sadsa@gmail.com"), 1);
    }

    @Test
    void delete() {
    }
}