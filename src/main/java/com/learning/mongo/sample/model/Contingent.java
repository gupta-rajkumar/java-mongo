package com.learning.mongo.sample.model;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.List;

@BsonDiscriminator(key = "_des", value = "Contingent")
public class Contingent extends Person {
    @BsonProperty
    private String id;

    @BsonProperty
    private int contractYears;

    @BsonProperty
    private List<Project> projects;

    @BsonCreator
    public Contingent() {}

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getContractYears() {
        return contractYears;
    }

    public void setContractYears(int contractYears) {
        this.contractYears = contractYears;
    }
}
