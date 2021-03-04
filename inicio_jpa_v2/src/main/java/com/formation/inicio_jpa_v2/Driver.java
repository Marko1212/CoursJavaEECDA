package com.formation.inicio_jpa_v2;

import com.formation.inicio_jpa_v2.entities.AddressEntity;
import com.formation.inicio_jpa_v2.entities.EventEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLOutput;
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

        e.setAddressEntity(a);

        Transaction tx = s.beginTransaction();

       // s.save(a);
       // System.out.println(a.getId());

        s.persist(e);




        tx.commit();

        printEventEntity();
        printAddressEntity();
    }

    private static void printEventEntity() {
        System.out.println("------- Affichage de mes events -------");

        Query<EventEntity> q = s.createQuery("from EventEntity", EventEntity.class);
        q.list().forEach(System.err::println);
    }

    private static void printAddressEntity() {
        System.out.println("------- Affichage de mes adresses -------");

        Query<AddressEntity> q = s.createQuery("from AddressEntity", AddressEntity.class);
        q.list().forEach(System.err::println);

    }


}
