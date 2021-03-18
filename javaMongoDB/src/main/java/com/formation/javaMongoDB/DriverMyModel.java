package com.formation.javaMongoDB;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.io.Serializable;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class DriverMyModel {
    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);

        // create codec registry for POJOs
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoDatabase db = mongoClient.getDatabase("ehpad").withCodecRegistry(pojoCodecRegistry);

        MongoCollection<User> userMongoCollection = db.getCollection("user", User.class);

        User user = new User(null,"Marko", "Askovic", 47);

        userMongoCollection.insertOne(user);




    }
}
