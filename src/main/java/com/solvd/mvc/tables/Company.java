package com.solvd.mvc.tables;

import java.util.List;

public class Company {
    private int id;
    private String name;
    private String location;
    private String phone;
    private String email;
    private List<Factories> factories;

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

    public List<Factories> getFactories() {
        return factories;
    }

    public void setFactories(List<Factories> factories) {
        this.factories = factories;
    }

}
