package com.learning.mongo.sample.model;

import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.*;

import java.util.Map;

public class Person {
    @BsonId()
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String serialNumber;
    @BsonProperty
    private String name;
    @BsonProperty
    private Integer age;
    @BsonExtraElements
    private Map<String, String> misc;

    @BsonCreator
    public Person() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Map<String, String> getMisc() {
        return misc;
    }

    public void setMisc(Map<String, String> misc) {
        this.misc = misc;
    }
}
