package com.solvd.dao.models;

import java.util.StringJoiner;

public class Company {
    private int id;
    private String name;
    private String location;
    private String phone;
    private String email;


    public Company() {
    }

    public Company(String name, String location, String phone, String email) {
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
    }

    public Company(int id, String name, String location, String phone, String email) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Company.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("location='" + location + "'")
                .add("phone=" + phone)
                .add("email='" + email + "'")
                .toString();
    }
}
