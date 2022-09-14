package com.solvd.mvc.tables;

public class Factories {
    private int id;
    private String name;
    private String prod_type;
    private int pa_month;
    private int company_id;

    public Factories(String name, String prod_type, int pa_month, int company_id) {
        this.name = name;
        this.prod_type = prod_type;
        this.pa_month = pa_month;
        this.company_id = company_id;
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

    public String getProd_type() {
        return prod_type;
    }

    public void setProd_type(String prod_type) {
        this.prod_type = prod_type;
    }

    public int getPa_month() {
        return pa_month;
    }

    public void setPa_month(int pa_month) {
        this.pa_month = pa_month;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }
}
