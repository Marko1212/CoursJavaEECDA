package com.formation.javaMongoDB;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.io.Serializable;
import java.util.Arrays;

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
        User user1 = new User(null,"anass", "tamsouri", 20);
        User user2 = new User(null,"jason", "douchet", 19);
        User user3 = new User(null,"laurie", "jezequel", 32);
        User user4 = new User(null,"najat", "ciesielczyk", 21);

       // userMongoCollection.insertOne(user);

       // userMongoCollection.insertMany(Arrays.asList(user1, user2, user3, user4));

        //TODO : corriger erreur update
        user.setAge(46);
        User resUser = userMongoCollection.findOneAndUpdate(new Document("first_name", "Marko"), new Document("age", 46));


        MongoIterable<User> users = userMongoCollection.find();

        for (User u : users) {
            System.out.println(u);
        }




    }
}
