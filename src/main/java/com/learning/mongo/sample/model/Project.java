package com.learning.mongo.sample.model;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class Project {
    @BsonProperty
    private String name;

    @BsonProperty
    private Integer years;

    @BsonCreator
    public Project() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", years=" + years +
                '}';
    }
}
