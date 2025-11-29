package com.learning.mongo.sample.model;

import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.*;
import org.bson.types.ObjectId;

import java.util.Map;

public class Person {
    @BsonProperty
    private String name;
    @BsonProperty
    private Integer age;
    @BsonExtraElements
    private Map<String, Object> misc;

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

    public Map<String, Object> getMisc() {
        return misc;
    }

    public void setMisc(Map<String, Object> misc) {
        this.misc = misc;
    }

    @Override
    public String toString() {
        return "Person{" +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", misc=" + misc +
                '}';
    }
}
