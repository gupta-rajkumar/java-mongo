package com.learning.mongo.sample.model;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.List;

@BsonDiscriminator(key = "_des",value = "Employee")
public class Employee extends Person {
    @BsonProperty
    private String employeeId;

    @BsonProperty
    private List<String> projects;

    @BsonCreator
    public Employee() {}

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }
}
