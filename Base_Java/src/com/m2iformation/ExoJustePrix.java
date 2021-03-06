package com.m2iformation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
 
public class ExoJustePrix
{
    private static final BufferedReader keyboardReading = new BufferedReader(new InputStreamReader(System.in));
 
    public static void main(String[] args) throws IOException
    {
        jouerAuJustePrix();
    }
 
    private static void jouerAuJustePrix() throws IOException
    {
        boolean continuerDeJouer = true;
        while (continuerDeJouer)
        {
            jouerUnJeu();
 
            System.out.println("Voulez-vous rejouer (O : Oui, N : Non) ?");
            String input = keyboardReading.readLine();
            if ("N".equals(input) || "n".equals(input))
            {
                continuerDeJouer = false;
                keyboardReading.close();
            }
        }
    }
 
    private static void jouerUnJeu() throws IOException
    {
 
        int prix = -1;
        int compteur = 0;
        Random rand = new Random();
        int justePrix = rand.nextInt(100) + 1;
 
        System.out.println("Vous devez deviner le juste prix...� vous de jouer!...");
 
        while (prix != justePrix)
        {
            String input = keyboardReading.readLine();
           try {
            prix = Integer.parseInt(input);
            } catch(Exception e) {
            	System.out.println("Vous devez entrez une valeur num�rique!");
            }
            ++compteur;
            if (compteur >= 7) {
            	System.out.println("Vous avez d�pass� le nombre de tentatives autoris�! Au revoir!");
            	return;
            }
            if (prix < justePrix)
                System.out.println("C'est plus");
 
            if (prix > justePrix)
                System.out.println("C'est moins");
 
        }
 
        System.out.println("Vous avez gagn� en " + compteur + " coup(s) !");
    }
 
}