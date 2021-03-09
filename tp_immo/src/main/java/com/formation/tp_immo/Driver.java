package com.formation.tp_immo;

import com.formation.tp_immo.entities.*;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.*;

public class Driver {

    private final static Session s = HibernateUtils.getSession();

    // raccourcis : psvm ou main, puis appuyer sur entrée
    public static void main(String[] args) {

        testCreate();

        s.close();
    }


    private static void testCreate() {
        System.out.println("------- Création de ma commune, mes quartiers, logements, types de logements et personnes -------");

        Commune valenciennes = new Commune("Valenciennes", 20, 50000);

        Quartier nordValenciennes = new Quartier("Nord Valenciennes");

        Quartier sudValenciennes = new Quartier("Sud Valenciennes");

        nordValenciennes.setCommune(valenciennes);
        sudValenciennes.setCommune(valenciennes);

        TypeLogement studio = new TypeLogement("Studio", 100);
        TypeLogement f1 = new TypeLogement("F1", 200);
        TypeLogement f2 = new TypeLogement("F2", 300);
        TypeLogement f3 = new TypeLogement("F3", 400);


        Logement log1 = new Logement("1a", "rue de Paris", 20, 400);
        Logement log2 = new Logement("3", "rue de Lille", 40, 500);
        Logement log3 = new Logement("4", "rue des Mimosas", 40, 500);
        Logement log4 = new Logement("7", "rue de la Gare", 50, 550);

        Logement log5 = new Logement("10b", "rue Wagram", 70, 600);

        log1.setTypeLogement(studio);
        log2.setTypeLogement(f1);
        log3.setTypeLogement(f1);
        log4.setTypeLogement(f2);

        log5.setTypeLogement(f3);


        log1.setQuartier(nordValenciennes);

        log2.setQuartier(nordValenciennes);

        log3.setQuartier(sudValenciennes);

        log4.setQuartier(sudValenciennes);

        log5.setQuartier(sudValenciennes);


        Individu personne1 = new Individu("Dupont", "Pierre", LocalDate.parse("2000-10-05"), "0123543354");
        Individu personne2 = new Individu("Martin", "Laurent", LocalDate.parse("1990-12-12"), "0423548554");
        Individu personne3 = new Individu("Roland", "Laurence", LocalDate.parse("1973-11-24"), "+33323543354");
        Individu personne4 = new Individu("Petit", "Romain", LocalDate.parse("1998-06-02"), "0512354335");
        Individu personne5 = new Individu("Thomas", "Emmanuel", LocalDate.parse("1960-05-08"), "0225554335");

        personne1.setLogement(log1);
        personne2.setLogement(log2);
        personne3.setLogement(log2);
        personne4.setLogement(log3);
        personne5.setLogement(log4);

        Transaction tx = s.beginTransaction();


        s.persist(valenciennes);

        s.persist(nordValenciennes);
        s.persist(sudValenciennes);

        s.persist(studio);
        s.persist(f1);
        s.persist(f2);
        s.persist(f3);

        s.persist(log1);
        s.persist(log2);
        s.persist(log3);
        s.persist(log4);
        s.persist(log5);

        s.persist(personne1);

        s.persist(personne2);

        s.persist(personne3);

        s.persist(personne4);

        s.persist(personne5);


        tx.commit();


    }



}
