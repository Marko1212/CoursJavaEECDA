package com.formation.javaMongoDB;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.or;
import static com.mongodb.client.model.Projections.*;

public class Driver {
    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);

        MongoDatabase db = mongoClient.getDatabase("france");

      /*  for (String name : db.listCollectionNames()) {
            System.out.println(name);
        } */

        MongoCollection<Document> villes = db.getCollection("villes");

        //MongoIterable<Document> res1 = villes.find().projection(fields(excludeId(), include("nom_reel")));

        //for (Document ville : res1) {
           // System.out.println(ville.get("nom_reel"));
          //  System.out.println(ville);
        //}

        //MongoIterable<Document> res2 = villes.find(new Document("nom_simple", "lille"));
     /*   MongoIterable<Document> res2 = villes.find(new Document("nom_simple",
                new Document("$regex", Pattern.compile("^(lille|comines|cambrai)$", Pattern.CASE_INSENSITIVE|Pattern.DOTALL))))
                .sort(new Document("nom_simple", 1));




        for (Document ville : res2) {
            System.out.println(ville);
        }

        */

        //long count59 = villes.countDocuments(new Document("dep", 59));
        //System.out.println(count59);

       // ArrayList<Document> arr = villes.find(new Document("dep", 59)).into(new ArrayList<>());
       // System.out.println(arr.size());

        MongoIterable<Document> res3 = villes.find(
                or(
                        eq("dep", 59),
                        eq("dep", 83)
                    )
        );

        for (Document ville : res3) {
            System.out.println(ville);
        }



    }

}
