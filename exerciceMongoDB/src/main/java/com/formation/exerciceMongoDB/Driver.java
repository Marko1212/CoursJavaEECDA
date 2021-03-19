package com.formation.exerciceMongoDB;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;

public class Driver {
    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);

        MongoDatabase db = mongoClient.getDatabase("statistiques_user");


        MongoCollection<Document> client = db.getCollection("client");

        //Question 1
        MongoIterable<Document> res1 = client.find(and(eq("name.first", "Brenda"), eq("name.last", "Oneal")));

        for (Document doc : res1) {
            System.out.println(doc);
            }

        //Question 2
        long countClients = client.countDocuments();
        System.out.println(countClients);

        //Question 3

        MongoIterable<Document> res2 = client.find(new Document("hairColor", "blond"));
        for (Document doc : res2) {
            System.out.println(doc);
        }

        //Question 4

        MongoIterable<Document> res3 = client.find(and(eq("hairColor", "blond"), eq("eyeColor", "blue")));

        for (Document doc : res3) {
            System.out.println(doc);
        }

        //Question 5

        ArrayList<Document> arr = client.find(new Document("hairColor", "ginger red")).into(new ArrayList<>());
        System.out.println(arr.size());

        //Question 6

        MongoIterable<Document> res4 = client.find();

        for (Document doc : res4) {
            System.out.println(doc.get("name", Document.class).getString("first") + " " + doc.get("name", Document.class).getString("last") + " est dans la compagnie " + doc.get("company") + ".");
        }


        //Question 7

        MongoIterable<Document> res5 = client.find(
                and(
                        gte("weight", 67),
                        lte("weight", 92)
                )
        );


        for (Document doc : res5) {
            System.out.println(doc);
        }

        //Question 8



        long countEmailTv = client.countDocuments(new Document("email",
                new Document("$regex", Pattern.compile(".tv$", Pattern.CASE_INSENSITIVE|Pattern.DOTALL))));

        System.out.println(countEmailTv);

        //Question 9

        long countEmailCom = client.countDocuments(new Document("email",
                new Document("$regex", Pattern.compile(".com$", Pattern.CASE_INSENSITIVE|Pattern.DOTALL))));

        System.out.println(countEmailCom);

        //Question 10

        long countEmailComOrTv = client.countDocuments(new Document("email",
                new Document("$regex", Pattern.compile(".com$|.tv$", Pattern.CASE_INSENSITIVE|Pattern.DOTALL))));

        System.out.println(countEmailComOrTv);


        //Question 11

        long countCalifornia = client.countDocuments(new Document("address",
                new Document("$regex", Pattern.compile(".*California.*", Pattern.CASE_INSENSITIVE|Pattern.DOTALL))));

        System.out.println(countCalifornia);





    }

}
