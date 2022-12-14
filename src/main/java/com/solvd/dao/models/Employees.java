package com.solvd.dao.models;

import java.util.StringJoiner;

public class Employees {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private int company_id;
    private int factories_id;
    private int cs_id;

    public Employees() {

    }

    public Employees(String firstname, String lastname, String email, int company_id, int factories_id, int cs_id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.company_id = company_id;
        this.factories_id = factories_id;
        this.cs_id = cs_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public int getFactories_id() {
        return factories_id;
    }

    public void setFactories_id(int factories_id) {
        this.factories_id = factories_id;
    }

    public int getCs_id() {
        return cs_id;
    }

    public void setCs_id(int cs_id) {
        this.cs_id = cs_id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Employees.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("firstname='" + firstname + "'")
                .add("lastname='" + lastname + "'")
                .add("email='" + email + "'")
                .add("company_id=" + company_id)
                .add("factories_id=" + factories_id)
                .add("cs_id=" + cs_id)
                .toString();
    }
}
