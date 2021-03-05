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
        System.out.println("------- Création de mes films -------");

        MovieEntity movie1 = new MovieEntity();

        MovieEntity movie2 = new MovieEntity();

        RoleEntity adventurer = new RoleEntity("Adventurer");

        RoleEntity warrior = new RoleEntity("Warrior");

        RoleEntity jedi = new RoleEntity("Jedi");

        ActorEntity lukeSkywalker = new ActorEntity("Mark Hamill", "Los Angeles");
        ActorEntity hanSolo = new ActorEntity("Harrisson Ford", "San Diego");

        List<RoleEntity> listOfRoles1 = Arrays.asList(adventurer, warrior);

        List<RoleEntity> listOfRoles2 = Arrays.asList(jedi, warrior);

        List<ActorEntity> listOfActors = Arrays.asList(lukeSkywalker, hanSolo);

        movie1.setRoleListOfMovie(listOfRoles1);

        movie2.setRoleListOfMovie(listOfRoles2);

        lukeSkywalker.setRoleListOfActor(listOfRoles2);

        hanSolo.setRoleListOfActor(listOfRoles1);



        /*
        AddressEntity a = new AddressEntity(null, "M2i", "4 avenue de l'Horizon", "", "59650", "Villeneuve-d'Ascq");

        UserEntity u1 = new UserEntity(null, "marko1212", "pass", "marko@toto.ru", null);
        UserEntity u2 = new UserEntity(null, "to", "passwo", "a@titi.ru", null);

        MovieEntity e2 = new MovieEntity("Formation mongodb", "Fonctionnement de la BigData avec mongodb", Calendar.getInstance(), true);

        ItemEntity i1 = new ItemEntity(null, "découverte", 10, 5, e);
        ItemEntity i2 = new ItemEntity(null, "test", 10, 3, e);

        ItemEntity i3 = new ItemEntity(null, "Php", 30, 2, e2);
        ItemEntity i4 = new ItemEntity(null, "Symfony", 30, 7, e2);

        List<RoleEntity> guests = Arrays.asList(
            new RoleEntity(null, "Marko", "marko@java.com", null),
            new RoleEntity(null, "Toto", "toto@nodejs.com", null)
        );

        e.setGuestList(guests);
        e2.setGuestList(guests);

        e.setAddressEntity(a);
        e.setUserEntity(u1);

        e2.setAddressEntity(a);
        e2.setUserEntity(u1);

        u2.setEventList(new ArrayList<>(Arrays.asList(
                new MovieEntity("event 1", "desc event 1", Calendar.getInstance(), false, u2),
                new MovieEntity("event 2", "desc event 2", Calendar.getInstance(), true, u2)


        )));

        */

        Transaction tx = s.beginTransaction();

        // s.save(a);
        // System.out.println(a.getId());

        s.persist(adventurer);
        s.persist(warrior);
        s.persist(jedi);

        s.persist(hanSolo);
        s.persist(lukeSkywalker);

        s.persist(movie1);
        s.persist(movie2);


        /*
        System.out.println("u2 persist");
        s.persist(u2);

        s.persist(i1);
        s.persist(i2);
        s.persist(i3);
        s.persist(i4);
        */

        tx.commit();

        /*
        printEventEntity();
        printAddressEntity();
        printUserEntity();
        */
    }

    /*

    private static void printEventEntity() {
        System.out.println("------- Affichage de mes events -------");

        Query<MovieEntity> q = s.createQuery("from EventEntity", MovieEntity.class);
        q.list().forEach(System.err::println);
    }

    private static void printAddressEntity() {
        System.out.println("------- Affichage de mes addresses -------");

        Query<AddressEntity> q = s.createQuery("from AddressEntity", AddressEntity.class);
        q.list().forEach(System.err::println);

    }

    private static void printUserEntity() {
        System.out.println("------- Affichage de mes users -------");
        s.createQuery("from UserEntity", UserEntity.class).list().forEach(System.err::println);
    }

    */

}
