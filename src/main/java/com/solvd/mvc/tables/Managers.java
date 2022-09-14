package com.solvd.mvc.tables;

public class Managers {
    private int employees_id;
    private String name;

    public Managers(int employees_id, String name) {
        this.employees_id = employees_id;
        this.name = name;
    }

    public int getEmployees_id() {

        return employees_id;
    }

    public void setEmployees_id(int employees_id) {
        this.employees_id = employees_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
