package com.learning.mongo.sample;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.codecs.pojo.Conventions;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Configuration
@PropertySource("classpath:application.properties")
public class MongoConfiguration {
    @Value("${com.sample.mongo.model.path}")
    private String modelClasses;
    @Value("${com.sample.mongo.uri}")
    private String uri;

    @Bean
    public MongoClient getClient() {
        return MongoClients.create(
                MongoClientSettings.builder().applyConnectionString(new ConnectionString(uri)).codecRegistry(fromRegistries(getDefaultCodecRegistry(),
                                fromProviders(PojoCodecProvider.builder().register(modelClasses)
                                        .conventions(List.of(Conventions.ANNOTATION_CONVENTION))
                                        .build())))
                        .build());
    }

}
