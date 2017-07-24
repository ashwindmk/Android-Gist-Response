package com.example.ashwin.gisttest.models;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by ashwin on 30/6/17.
 */

@JsonObject
public class Employee {

    public Employee() { }

    @JsonField(name = "id")
    private String id;

    @JsonField(name = "name")
    private String name;

    @JsonField(name = "age")
    private int age;

    @JsonField(name = "company")
    private String company;

    @JsonField(name = "salary")
    private double salary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
