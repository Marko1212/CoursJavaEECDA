package com.formation.netflix;

import com.formation.netflix.entities.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.*;

public class Driver {

    private final static Session s = HibernateUtils.getSession();

    // raccourcis : psvm ou main, puis appuyer sur entrée
    public static void main(String[] args) {

        testCreate();

        s.close();
    }


    private static void testCreate() {
        System.out.println("------- Création de mes films, acteurs et rôles -------");

        MovieEntity starWars = new MovieEntity();

        MovieEntity returnOfJedi = new MovieEntity();

        MovieEntity theEmpireStrikesBack = new MovieEntity();

        MovieEntity theForceAwakens = new MovieEntity();

        MovieEntity raidersOfTheLostArk = new MovieEntity();

        ActorEntity hamill = new ActorEntity("Mark Hamill", "Los Angeles");
        ActorEntity ford = new ActorEntity("Harrison Ford", "San Diego");
        ActorEntity fisher = new ActorEntity("Carrie Fisher", "San Francisco");
        ActorEntity barrero = new ActorEntity("Jesus Barrero", "Mexico City");

        RoleEntity hanSolo = new RoleEntity("Han Solo");

        RoleEntity lukeSkywalker = new RoleEntity("Luke Skywalker");


        RoleEntity princessLeia = new RoleEntity("Princess Leia");


        RoleEntity indianaJones = new RoleEntity("Indiana Jones");


        starWars.addRole(hanSolo);
        starWars.addRole(lukeSkywalker);
        starWars.addRole(princessLeia);

        returnOfJedi.addRole(hanSolo);
        returnOfJedi.addRole(lukeSkywalker);
        returnOfJedi.addRole(princessLeia);

        theEmpireStrikesBack.addRole(hanSolo);
        theEmpireStrikesBack.addRole(lukeSkywalker);
        theEmpireStrikesBack.addRole(princessLeia);

        theForceAwakens.addRole(lukeSkywalker);

        raidersOfTheLostArk.addRole(indianaJones);


        ford.addRole(hanSolo);
        ford.addRole(indianaJones);

        hamill.addRole(lukeSkywalker);
        barrero.addRole(lukeSkywalker);

        fisher.addRole(princessLeia);





        Transaction tx = s.beginTransaction();



        s.persist(hanSolo);

        s.persist(princessLeia);

        s.persist(lukeSkywalker);

        s.persist(indianaJones);



        tx.commit();


    }



}
