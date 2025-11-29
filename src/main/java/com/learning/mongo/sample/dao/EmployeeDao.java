package com.learning.mongo.sample.dao;

import com.learning.mongo.sample.model.Employee;
import com.mongodb.client.MongoClient;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao extends MongoDao<Employee> {

    public EmployeeDao(MongoClient client) {
        super(client, Employee.class);
    }
}
