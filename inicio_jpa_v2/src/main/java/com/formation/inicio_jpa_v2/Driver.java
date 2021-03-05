package com.formation.inicio_jpa_v2;

import com.formation.inicio_jpa_v2.entities.*;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLOutput;
import java.util.*;

public class Driver {

    private final static Session s = HibernateUtils.getSession();

    // raccourcis : psvm ou main, puis appuyer sur entrée
    public static void main(String[] args) {

        testCreate();

        s.close();
    }

    private static <T> void validation(T entity) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<T>> constraints = validator.validate(entity);

        constraints.forEach(c -> {
            System.err.printf("%s - L'attribut : %s a rencontré une erreur : %s%n", entity.getClass().getSimpleName(), c.getPropertyPath(), c.getMessage());
        });

    }

    private static void testCreate() {
        System.out.println("------- Création de mes events et de mes addresses -------");

        EventEntity e = new EventEntity("Meetup flutter", "Conférence sur le framework flutter", Calendar.getInstance(), false);

        AddressEntity a = new AddressEntity(null, "M2i", "4 avenue de l'Horizon", "", "59650", "Villeneuve-d'Ascq");

        UserEntity u1 = new UserEntity(null, "marko1212", "pass", "marko@toto.ru", null);
        UserEntity u2 = new UserEntity(null, "to", "passwo", "a@titi.ru", null);

        System.out.println("---------- Erreur(s) ----------");
        validation(u1);
        System.out.println("-------------------------------");
        validation(u2);
        System.out.println("---------- Fin Erreur(s) ----------");

        EventEntity e2 = new EventEntity("Formation mongodb", "Fonctionnement de la BigData avec mongodb", Calendar.getInstance(), true);

        ItemEntity i1 = new ItemEntity(null, "découverte", 10, 5, e);
        ItemEntity i2 = new ItemEntity(null, "test", 10, 3, e);

        ItemEntity i3 = new ItemEntity(null, "Php", 30, 2, e2);
        ItemEntity i4 = new ItemEntity(null, "Symfony", 30, 7, e2);

        List<GuestEntity> guests = Arrays.asList(
            new GuestEntity(null, "Marko", "marko@java.com", null),
            new GuestEntity(null, "Toto", "toto@nodejs.com", null)
        );

        e.setGuestList(guests);
        e2.setGuestList(guests);

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

        s.persist(i1);
        s.persist(i2);
        s.persist(i3);
        s.persist(i4);

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
