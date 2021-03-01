package com.m2iformation.jdbcVilles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.m2iformation.jdbcVilles.models.Ville;
import com.m2iformation.jdbcVilles.services.VilleService;

public class Driver {
	private final static String PATH_CSV_VILLE = "./villes_france.csv";

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		remplissageDeLaBase();
		long endTime = System.nanoTime();
		System.out.println("Temps d'éxécution : " + (endTime - startTime) / 1_000_000 + " ms");
	}

	private static void remplissageDeLaBase(){
		VilleService villeService = new VilleService();
		if (villeService.countOccurence() == 0){
			try (BufferedReader br = new BufferedReader(new FileReader(PATH_CSV_VILLE))){
				String line;
				while((line = br.readLine()) != null){
					Ville ville = new Ville().stringToField(line);
					villeService.create(ville);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
