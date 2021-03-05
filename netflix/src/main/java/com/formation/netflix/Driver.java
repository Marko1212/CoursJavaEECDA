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

        MovieEntity raidersOfTheLostArk = new MovieEntity();


        ActorEntity hamill = new ActorEntity("Mark Hamill", "Los Angeles");
        ActorEntity ford = new ActorEntity("Harrison Ford", "San Diego");

        RoleEntity hanSolo = new RoleEntity("Han Solo", starWars, ford);

        RoleEntity hanSolo2 = new RoleEntity("Han Solo", returnOfJedi, ford);

        RoleEntity lukeSkywalker = new RoleEntity("Luke Skywalker", starWars, hamill);

        RoleEntity lukeSkywalker2 = new RoleEntity("Luke Skywalker", returnOfJedi, hamill);

        RoleEntity indianaJones = new RoleEntity("Indiana Jones", raidersOfTheLostArk, ford);







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



        s.persist(hanSolo);
        s.persist(hanSolo2);
        s.persist(lukeSkywalker);
        s.persist(lukeSkywalker2);

        s.persist(indianaJones);

        tx.commit();

        /*
        System.out.println("u2 persist");
        s.persist(u2);

        s.persist(i1);
        s.persist(i2);
        s.persist(i3);
        s.persist(i4);
        */



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
