package com.solvd.mvc.tables;

import java.util.List;

public class Company {
    private int id;
    private String name;
    private String location;
    private int phone;
    private String email;
    private List<Factories> factories;

    public Company(String name, String location, int phone, String email) {
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
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
