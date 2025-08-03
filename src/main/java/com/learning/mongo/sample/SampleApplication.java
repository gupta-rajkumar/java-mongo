package com.learning.mongo.sample;

import com.mongodb.client.MongoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SampleApplication.class, args);
		MongoDao dao = context.getBean(MongoDao.class);
		dao.insertContingent();
	}

}
