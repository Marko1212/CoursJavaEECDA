package com.m2iformation.jdbcVilles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.m2iformation.jdbcVilles.models.Ville;
import com.m2iformation.jdbcVilles.services.VilleService;

public class Driver {
	private final static String PATH_CSV_VILLE = "./villes_france.csv";

	public static void main(String[] args) {
		//long startTime = System.nanoTime();
		//remplissageDeLaBase();
		//long endTime = System.nanoTime();
		//System.out.println("Temps d'éxécution : " + (endTime - startTime) / 1_000_000 + " ms");
		//VilleService villeService = new VilleService();
		//villeService.update(1, new Ville(1, "01", "ozana", "bla", "bla", "bla", "bla", "bla", "bla", "bl", "bl", "bl", "bla", "bla", "ll", "bla", "alo", "blo", "250", "bla", "az", "azla", "alzl", "azzl", "alll", "alel", "llal"));
		//villeService.delete(1);
		//System.out.println(villeService.findByID(2));
		/*for (Ville ville : villeService.searchByName("alencien")) {
		System.out.println(ville); 
		}*/
		
		VilleService villeService = new VilleService();
		System.out.println(villeService.findByID(99999));
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Veuillez faire une recherche par nom de ville...");

		String reponse = sc.nextLine();
		
		
		if (villeService.searchByName(reponse).isEmpty()) {
			return;
		}
		
		for (Ville ville : villeService.searchByName(reponse)) {
		System.out.println(ville); 
		}
		
		if (!villeService.searchByName(reponse).isEmpty()) {
			System.out.println("Souhaitez vous faire des modifications sur une des réponses?");
			System.out.println("Mettre à jour (1)");
			System.out.println("Supprimer (2)");
			String reponse2 = sc.nextLine();
			
			switch (reponse2) {
			
			case "1":
				System.out.println("Veuillez indiquer l'identifiant de la ville que vous souhaitez mettre à jour...");
				break;
			case "2":
				System.out.println("Veuillez indiquer l'identifiant de la ville que vous souhaitez supprimer...");
				break;
			default:
				System.out.println("Choix inexistant. Bye bye!");
				break;
		}
			
			if (reponse2.equals("2")) {
				String reponse3 = sc.nextLine();
				for (Ville ville : villeService.searchByName(reponse)) {
					
				if (ville.getId() == Integer.parseInt(reponse3)) {
				villeService.delete(Integer.parseInt(reponse3));
				break;
				}
			}
			}
			
			if (reponse2.equals("1")) {
				String reponse3 = sc.nextLine();
				
				for (Ville vill : villeService.searchByName(reponse)) {
					
					if (vill.getId() == Integer.parseInt(reponse3)) {
						Ville ville = new Ville();
						ville.setId(Integer.parseInt(reponse3));
						System.out.println("Veuillez entrer le nouveau département");
						ville.setDepartement(sc.nextLine());
						System.out.println("Veuillez entrer le nouveau slug");
						ville.setSlug(sc.nextLine());
						System.out.println("Veuillez entrer le nouveau nom");
						ville.setNom(sc.nextLine());
						System.out.println("Veuillez entrer le nouveau nom simple");
						ville.setNomSimple(sc.nextLine());
						System.out.println("Veuillez entrer le nouveau nom réel");
						ville.setNomReel(sc.nextLine());
						System.out.println("Veuillez entrer le nouveau nom Soundex");
						ville.setNomSoundex(sc.nextLine());
						System.out.println("Veuillez entrer le nouveau nom Metaphone");
						ville.setNomMetaphone(sc.nextLine());
						System.out.println("Veuillez entrer le nouveau code postal");
						ville.setCodePostal(sc.nextLine());
						System.out.println("Veuillez entrer le nouveau numéro de commune");
						ville.setNumCommune(sc.nextLine());
						System.out.println("Veuillez entrer le nouveau code commune");
						ville.setCodeCommune(sc.nextLine());
						System.out.println("Veuillez entrer le nouvel arrondissement");
						ville.setArrondissement(sc.nextLine());
						System.out.println("Veuillez entrer le nouveau canton");
						ville.setCanton(sc.nextLine());
						villeService.update(Integer.parseInt(reponse3), ville);
						break;
					}
		
					}

					}
				
				
		
}
		
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
