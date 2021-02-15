package com.m2iformation;

import java.util.Arrays;

public class Hello2 {

    public static void main(String[] args) {
        Personne samsam = new Personne();
        samsam.prenom = "samuel";
        samsam.nom = "michaux";

        samsam.getNom();
        
        Personne toto = new Personne();
        toto.prenom = "toto";
        toto.nom = "titi";

        toto.getNom();

    }
}

class Personne {
    String nom;
    String prenom;

    public void getNom(){
        System.out.println(this.nom + " " + this.prenom);
    }
}