package com.solvd.mvc.tables;

public class CustomerService {
    private int id;
    private String location;
    private String work_from;
    private String work_till;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
