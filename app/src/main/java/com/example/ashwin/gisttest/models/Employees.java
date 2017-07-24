package com.example.ashwin.gisttest.models;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.bluelinelabs.logansquare.annotation.OnJsonParseComplete;
import com.bluelinelabs.logansquare.annotation.OnPreJsonSerialize;

import java.util.ArrayList;

/**
 * Created by ashwin on 30/6/17.
 */

@JsonObject
public class Employees {

    public Employees() { }

    @JsonField(name = "employees")
    private ArrayList<Employee> employees;

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    /*
     * Optional callback method to do something when your
     * object is done parsing.
     */
    @OnJsonParseComplete
    void onParseComplete() {
        // Do some fancy post-processing stuff after parsing here
    }

    /*
     * Optional callback method to do something before your
     * object serializes.
     */
    @OnPreJsonSerialize
    void onPreSerialize() {
        // Do some fancy pre-processing stuff before serializing here
    }
}
