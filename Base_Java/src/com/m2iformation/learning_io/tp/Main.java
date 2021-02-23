package com.m2iformation.learning_io.tp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Ville> villes = new ArrayList<Ville>();

		try (BufferedReader br = new BufferedReader(new FileReader("villes_france.csv"))) {
			
			String ligne;
			List<String> ligneTableau;
			while ((ligne = br.readLine()) != null) {
			
				ligneTableau = Arrays.asList(ligne.split(","));
				
				//System.out.println(ligneTableau);
				
				
				Ville ville = new Ville();
				
				ville.setId((String)ligneTableau.get(0));
				ville.setDepartement((String) ligneTableau.get(1));
				ville.setSlug((String) ligneTableau.get(2));
				ville.setNom((String) ligneTableau.get(3));
				ville.setNomSimple((String) ligneTableau.get(4));
				ville.setNomReel((String) ligneTableau.get(5));
				ville.setNomSoundex((String) ligneTableau.get(6));
				ville.setNomMetaphore((String) ligneTableau.get(7));
				ville.setCodePostal((String) ligneTableau.get(8));
				ville.setNumeroDeCommune((String) ligneTableau.get(9));
				ville.setCodeCommune((String) ligneTableau.get(10));
				ville.setArrondissement((String) ligneTableau.get(11));
				ville.setCanton((String) ligneTableau.get(12));
				ville.setAmdi((String) ligneTableau.get(13));
				ville.setPopulation2010((String) ligneTableau.get(14));
				ville.setPopulation1999((String) ligneTableau.get(15));
				ville.setPopulation2012((String) ligneTableau.get(16));
				ville.setDensite2010((String) ligneTableau.get(17));
				ville.setSuperficie((String) ligneTableau.get(18));
				ville.setLongitudeDeg((String) ligneTableau.get(19));
				ville.setLatitudeDeg((String) ligneTableau.get(20));
				ville.setLongitudeGrd((String) ligneTableau.get(21));
				ville.setLatitudeGrd((String) ligneTableau.get(22));
				ville.setLongitudeDms((String) ligneTableau.get(23));
				ville.setLatitudeDms((String) ligneTableau.get(24));
				ville.setAltitudeMin((String) ligneTableau.get(25));
				ville.setAltitudeMax((String) ligneTableau.get(26));
				
				villes.add(ville);
			}
			
		} catch (FileNotFoundException f) {
			f.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(villes.get(3));
	}

}
