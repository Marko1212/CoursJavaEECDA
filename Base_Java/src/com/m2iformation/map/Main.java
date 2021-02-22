package com.m2iformation.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> names = new ArrayList<>();
		
		names.add("Olga");
		
		
		HashMap<String, String> map = new HashMap<>();
		
		map.put("Michaux", "Samuel");
		
		for (Map.Entry<String, String> m : map.entrySet()) {
			System.out.println("key " + m.getKey());
			System.out.println("value " + m.getValue());
		}
		
		map.forEach((key, value) -> System.out.println(key + " " + value));
		
		
		map.get("Michaux");
		
		ArrayList<Ville> villes = new ArrayList<>();
		
		villes.add(new Ville("Lille", 1_000_000, "59000", 35));
		
		
		for (Ville ville: villes) {
			if (ville.nom.equals("Lille")) {
				System.out.println(ville);
			}
		}
		
		HashMap<String, Ville> villeMap = new HashMap<>();
		
		villeMap.put("Lille", new Ville("Lille", 1_000_000, "59000", 35));
		
		System.out.println(villeMap.get("Lille"));
		
		
	}

}

class Ville {
	String nom;
	int nbHabitants;
	String codePostal;
	int surface;
	public Ville(String nom, int nbHabitants, String codePostal, int surface) {
		super();
		this.nom = nom;
		this.nbHabitants = nbHabitants;
		this.codePostal = codePostal;
		this.surface = surface;
	}	
	
	
}
