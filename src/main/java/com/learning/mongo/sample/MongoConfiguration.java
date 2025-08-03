package com.learning.mongo.sample;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.Conventions;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Configuration
public class MongoConfiguration implements InitializingBean {
    private static final String PACKAGE = "com.learning.mongo.sample.model";
    private static final String URI = "mongodb://127.0.0.1:27017/?directConnection=true&serverSelectionTimeoutMS=2000";
    private MongoClient client;
    private static final PojoCodecProvider POJO_CODEC_PROVIDER = PojoCodecProvider
            .builder()
            .register(PACKAGE)
            .conventions(List.of(Conventions.ANNOTATION_CONVENTION))
            .build();
    private static final CodecRegistry CODEC_REGISTRY = fromRegistries(
            getDefaultCodecRegistry(),
            fromProviders(POJO_CODEC_PROVIDER));

    @Bean
    public MongoClient getClient() {
        return client;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        client = MongoClients.create(
                MongoClientSettings.builder()
                        .applyConnectionString(new ConnectionString(URI))
                        .codecRegistry(CODEC_REGISTRY)
                        .build());
    }
}
