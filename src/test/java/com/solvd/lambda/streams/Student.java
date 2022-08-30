package com.solvd.lambda.streams;

public class Student {
    private String name;
    private int age;
    private Status status;
    public Student(String name, int age, Status status){
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }
}
