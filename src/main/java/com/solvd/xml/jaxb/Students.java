package com.solvd.xml.jaxb;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "students")
public class Students {
    private int id;
    private String firstname;
    private String lastname;
    private int age;
    private int year;

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }


    public String getFirstname() {
        return firstname;
    }

    @XmlElement
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @XmlElement

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }

    public int getYear() {
        return year;
    }

    @XmlElement
    public void setYear(int year) {
        this.year = year;
    }
}
