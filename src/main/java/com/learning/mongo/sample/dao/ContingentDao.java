package com.learning.mongo.sample.dao;

import com.learning.mongo.sample.model.Contingent;
import com.mongodb.client.MongoClient;
import org.springframework.stereotype.Component;

@Component
public class ContingentDao extends MongoDao<Contingent>{
    public ContingentDao(MongoClient client) {
        super(client, Contingent.class);
    }
}
