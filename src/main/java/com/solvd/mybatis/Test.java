package com.solvd.mybatis;

import com.solvd.mybatis.service.services.Service;

public class Test {
    public static void main(String[] args) {
        Service service = new Service();
        Student student = service.getById(2);
        System.out.println(student);
    }
}
