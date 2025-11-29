package com.learning.mongo.sample.dao;

import com.learning.mongo.sample.model.Person;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import jakarta.annotation.PreDestroy;

public abstract class MongoDao<T extends Person> implements Dao<T> {

    public final MongoClient client;
    public static final String DB = "company";

    public MongoCollection<T> collection;

    public MongoDao(MongoClient client, Class<T> clazz) {
        this.client = client;
        this.collection = client.getDatabase(DB).getCollection("person", clazz);
    }

    @Override
    public void persist(T entity) {
        collection.insertOne(entity);
    }

    @Override
    public void update(T entity) {
        collection.insertOne(entity);
    }

    @PreDestroy
    public void destroy() throws Exception {
        client.close();
    }

}
