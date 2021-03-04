package com.formation.inicio_jpa_v2;

import com.formation.inicio_jpa_v2.entities.AddressEntity;
import com.formation.inicio_jpa_v2.entities.EventEntity;
import com.formation.inicio_jpa_v2.entities.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class Driver {

    private final static Session s = HibernateUtils.getSession();

    // raccourcis : psvm ou main, puis appuyer sur entrée
    public static void main(String[] args) {

        testCreate();

        s.close();
    }

    private static void testCreate() {
        System.out.println("------- Création de mes events et de mes addresses -------");

        EventEntity e = new EventEntity("Meetup flutter", "Conférence sur le framework flutter", Calendar.getInstance(), false);

        AddressEntity a = new AddressEntity(null, "M2i", "4 avenue de l'Horizon", "", "59650", "Villeneuve-d'Ascq");

        UserEntity u1 = new UserEntity(null, "marko1212", "pass", "marko@toto.ru", null);
        UserEntity u2 = new UserEntity(null, "toto2121", "passw", "tata@titi.ru", null);

        EventEntity e2 = new EventEntity("Formation mongodb", "Fonctionnement de la BigData avec mongodb", Calendar.getInstance(), true);


        e.setAddressEntity(a);
        e.setUserEntity(u1);

        e2.setAddressEntity(a);
        e2.setUserEntity(u1);

        u2.setEventList(new ArrayList<>(Arrays.asList(
                new EventEntity("event 1", "desc event 1", Calendar.getInstance(), false, u2),
                new EventEntity("event 2", "desc event 2", Calendar.getInstance(), true, u2)


        )));


        Transaction tx = s.beginTransaction();

        // s.save(a);
        // System.out.println(a.getId());

        s.persist(e);
        s.persist(e2);
        System.out.println("u2 persist");
        s.persist(u2);


        tx.commit();

        printEventEntity();
        printAddressEntity();
        printUserEntity();
    }

    private static void printEventEntity() {
        System.out.println("------- Affichage de mes events -------");

        Query<EventEntity> q = s.createQuery("from EventEntity", EventEntity.class);
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

}
