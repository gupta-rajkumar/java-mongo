package com.learning.mongo.sample;

import com.learning.mongo.sample.model.Contingent;
import com.learning.mongo.sample.model.Employee;
import com.learning.mongo.sample.model.Person;
import com.learning.mongo.sample.model.Project;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

@Service
public class MongoDao {
    MongoClient mongoClient;

    public MongoDao(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public void testDb() {
        MongoDatabase mongoDatabase = mongoClient.getDatabase("palace");
        try {
            // Send a ping to confirm a successful connection
            Bson command = new BsonDocument("ping", new BsonInt64(1));
            Document commandResult = mongoDatabase.runCommand(command);
            System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
        } catch (MongoException me) {
            System.err.println(me);
        }
    }

    public void insert() {
        MongoDatabase mongoDatabase = mongoClient.getDatabase("palace");
        MongoCollection<Document> collection = mongoDatabase.getCollection("jaipur");
        Document document = new Document();
        document.append("place", "test").append("length", "test");
        collection.insertOne(document);
    }

    public void insertEmployee() {
        MongoDatabase mongoDatabase = mongoClient.getDatabase("company");
        MongoCollection<Person> collection  = mongoDatabase.getCollection("person", Person.class);
        Employee p = new Employee();
        p.setAge(22);
        p.setName("Rajkumar");
        p.setEmployeeId("34414A");
        p.setProjects(List.of("apple", "google"));
        collection.insertOne(p);
    }

    public void insertContingent() {
        MongoDatabase mongoDatabase = mongoClient.getDatabase("company");
        MongoCollection<Person> collection  = mongoDatabase.getCollection("person", Person.class);
        Contingent p = new Contingent();
        p.setAge(22);
        p.setName("Lou Reed");
        p.setId("34414Ac_a");
        p.setContractYears(2);
        p.setMisc(Map.of("DOB", "12-10,1999","Location", "Mumbai"));
        Project projectA = new Project();
        projectA.setName("apple");
        projectA.setYears(2);
        Project projectB = new Project();
        projectB.setName("windows");
        projectB.setYears(4);
        p.setProjects(List.of(projectA,projectB));
        collection.insertOne(p);
    }

}
