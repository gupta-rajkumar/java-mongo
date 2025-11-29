package com.learning.mongo.sample.dao;

public interface Dao<T> {
    void persist(T entity);
    void update(T entity);
}
