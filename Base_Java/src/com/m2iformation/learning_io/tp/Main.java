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
				//System.out.println(ligneTableau.get(0));
				ville.setId(Integer.parseInt(ligneTableau.get(0).replaceAll("[^0-9]", "")));
				ville.setDepartement(ligneTableau.get(1));
				ville.setSlug(ligneTableau.get(2));
				ville.setNom(ligneTableau.get(3));
				ville.setNomSimple(ligneTableau.get(4));
				ville.setNomReel(ligneTableau.get(5));
				ville.setNomSoundex(ligneTableau.get(6));
				ville.setNomMetaphore(ligneTableau.get(7));
				ville.setCodePostal(ligneTableau.get(8));
				ville.setNumeroDeCommune(ligneTableau.get(9));
				ville.setCodeCommune(ligneTableau.get(10));
				ville.setArrondissement(ligneTableau.get(11));
				ville.setCanton(ligneTableau.get(12));
				ville.setAmdi(ligneTableau.get(13));
				ville.setPopulation2010(ligneTableau.get(14));
				ville.setPopulation1999(ligneTableau.get(15));
				ville.setPopulation2012(ligneTableau.get(16));
				ville.setDensite2010(ligneTableau.get(17));
				ville.setSuperficie(ligneTableau.get(18));
				ville.setLongitudeDeg(ligneTableau.get(19));
				ville.setLatitudeDeg(ligneTableau.get(20));
				ville.setLongitudeGrd(ligneTableau.get(21));
				ville.setLatitudeGrd(ligneTableau.get(22));
				ville.setLongitudeDms(ligneTableau.get(23));
				ville.setLatitudeDms(ligneTableau.get(24));
				ville.setAltitudeMin(ligneTableau.get(25));
				ville.setAltitudeMax(ligneTableau.get(26));
				
				villes.add(ville);
			}
			
		} catch (FileNotFoundException f) {
			f.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(villes.get(0));
		System.out.println(villes.get(1));
		System.out.println(villes.get(2));
		System.out.println(villes.get(3));
	}

}
