package com.solvd.mvc.tables;

import java.util.List;
import java.util.StringJoiner;

public class CustomerService {
    private int id;
    private String location;
    private String work_from;
    private String work_till;
    private List<Customer> customers;

    public CustomerService() {
    }

    public CustomerService(String location, String work_from, String work_till) {
        this.location = location;
        this.work_from = work_from;
        this.work_till = work_till;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWork_from() {
        return work_from;
    }

    public void setWork_from(String work_from) {
        this.work_from = work_from;
    }

    public String getWork_till() {
        return work_till;
    }

    public void setWork_till(String work_till) {
        this.work_till = work_till;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomerService.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("location='" + location + "'")
                .add("work_from='" + work_from + "'")
                .add("work_till='" + work_till + "'")
                .add("customers=" + customers)
                .toString();
    }
}
