package com.m2iformation.poo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Program {
	
	static ArrayList<Article> stock = new ArrayList<>(Arrays.asList(
			new Article(1,"Stylo", 130, 4),
			new Article(2, "Gomme", 5, 130),
			new Article(3,"Calculatrice", 120, 120),
			new Article(4,"Ciseaux", 10, 20),
			new Article(5,"Verre", 120, 33),
			new Article(6,"Crayon", 3, 44),
			new Article(7, "Colle", 10, 55),
			new Article(8, "Stylo BIC", 14, 22)

	));
	
	static Article search(List<Article> articles, int numReference){
		for (Article article: articles) {
		if (article.getNumeroReference() == numReference) {
			return article;
		}
		}
		return null;
	}
		
	static boolean addArticle(List<Article> articles, Article articleToAdd) {
			if (search(articles, articleToAdd.getNumeroReference()) == null) {
				articles.add(articleToAdd);
				return true;
				}
			
			return false;
		
		}
	
	static boolean deleteArticle(List<Article> articles, int numReference) {

		
			for(int j = 0; j < articles.size(); j++)
			{
			    Article article = articles.get(j);

			    if(article.getNumeroReference() == numReference){
			        articles.remove(article);
			        return true;
			    }

			}
			
			return false;
		
		}
		

	static boolean modifyArticle(List<Article> articles, int numReference, Article updatedArticle) {
		
		for(int j = 0; j < articles.size(); j++)
		{
		    Article article = articles.get(j);
		    
		    if(article.getNumeroReference() == numReference){
		    	
		    	article.setNom(updatedArticle.getNom());
		    	article.setPrix(updatedArticle.getPrix());
		    	article.setQuantiteStock(updatedArticle.getQuantiteStock());
		    	//System.out.println(article);
		    	//display(stock);
		    	return true;
		    }

		    /*
		    if(article.getNumeroReference() == numReference){
		        articles.set(j, updatedArticle);
		        return true;
		    } */

		}
		
		
		return false;
	}
	

	static List<Article> searchPerName(List<Article> articles, String name) {
		
		List<Article> results = new ArrayList<Article>();
		
		for(int j = 0; j < articles.size(); j++)
		{
		    Article article = articles.get(j);

		    if(article.getNom().toLowerCase().contains(name)){
		    	results.add(article);
		    }

		}
		
		if (!results.isEmpty()) {
			return results;
		}
		
		return null;
	}
	
	
	static List <Article> searchPerPriceInterval(List<Article> articles, double min, double max) {

		List<Article> results = new ArrayList<Article>();
		
		for(int j = 0; j < articles.size(); j++)
		{
		    Article article = articles.get(j);

		    if(article.getPrix() >= min && article.getPrix() <= max){
		        results.add(article);
		    }

		}
		
		if (!results.isEmpty()) {
			return results;
		}
		
		return null;
	}
	
	
	static void display(List<Article> articles) { 
		
		for (Article article : articles) {
		
			System.out.println(article);
			
		}
	}
	

	public static void main(String[] args) {
	
		Scanner lecteur = new Scanner(System.in);
		
		int choix = 0 , num, quantite;
		double prix, min, max;
		String nom, reponse="";
		
		boolean continuer = true;
		
		do {
		
		System.out.println("1 - Rechercher un article par r�f�rence");
		System.out.println("2 - Ajouter un article au stock");
		System.out.println("3 - Supprimer un article");
		System.out.println("4 - Modifier un article");
		System.out.println("5 - Rechercher un article par nom");
		System.out.println("6 - Rechercher un article par intervalle de prix de vente");
		System.out.println("7 - Afficher tous les articles");
		System.out.println("8 - Quitter");
		System.out.print("Votre choix : ");
		
		
		try {
	    	choix = lecteur.nextInt();
    	  	} catch (Exception e) {
    	  		System.out.println("Vous devez entrer un nombre entier entre 1 et 8!");
    	  		lecteur.nextLine();
    	  		//lecteur.close();
    	  	}
		
		switch (choix) {
		  
		  case 0:
			break;
	      case 1:
	    	
	    	System.out.println("Entrez un numero de r�f�rence : ");
	    	num = lecteur.nextInt();
	    	if (search(stock, num) == null) {
	    		System.out.println("Le stock n'a pas d'article avec cette r�f�rence!");
	    		lecteur.nextLine();
	    		break;
	    	} else {
	    		System.out.println(search(stock, num));
	    		lecteur.nextLine();
	    		break;
	    	}
	 
	      case 2:
		    	
		    	System.out.println("Entrez un numero de r�f�rence : ");
		    	num = lecteur.nextInt();
		    	
		    	if (search(stock, num) !=null) {
		    		System.out.println("L'article avec ce num�ro de r�f�rence existe d�j� au stock!");
		    		lecteur.nextLine();
		    		break;
		    	}
		   
		    	lecteur.nextLine();
		    	System.out.println("Entrez un nom d'article : ");
		    	nom = lecteur.nextLine();
		    	System.out.println("Entrez un prix : ");
		    	prix = lecteur.nextDouble();
		    	System.out.println("Entrez une quantit� : ");
		    	quantite = lecteur.nextInt();
		    	
		    	
		    	
		    	Article articleAAjouter = new Article(num, nom, prix, quantite);
		    	
		    	addArticle(stock, articleAAjouter);
		    	//display(stock);
		    	System.out.println("L'article a bien �t� ajout� au stock!");
		    	lecteur.nextLine();
		    	break;
		    	
		  
	      case 3:
	    	  
	    	  	System.out.println("Entrez un numero de r�f�rence : ");
		    	num = lecteur.nextInt();
		    	lecteur.nextLine();
		    	
		    	if(deleteArticle(stock, num)) {
		    		//display(stock);
		    		System.out.println("L'article a bien �t� supprim� du stock!");
		    		break;
		    	} else {
		    		System.out.println("L'article avec cette r�f�rence n'existe pas!");
		    		break;
		    	}
	      
	      case 4:
	    	  
	    	  	System.out.println("Entrez un numero de r�f�rence : ");
	    	
		    	num = lecteur.nextInt();
		    	
		    	if (search(stock, num) == null) {
		    		System.out.println("Le stock n'a pas d'article avec cette r�f�rence!");
		    		lecteur.nextLine();
		    		break;
		    	}
		    	
		    		lecteur.nextLine();
		    		System.out.println("Entrez un nom d'article : ");
			    	nom = lecteur.nextLine();
			    	System.out.println("Entrez un prix : ");
			    	prix = lecteur.nextDouble();
			    	System.out.println("Entrez une quantit� : ");
			    	quantite = lecteur.nextInt();
			    	
			    	lecteur.nextLine();
			    	
			    	Article articleModifie = new Article(num, nom, prix, quantite);
		    		modifyArticle(stock, num, articleModifie);
		    		//display(stock);
		    		System.out.println("L'article a bien �t� modifi�!");
		    		break;
		    	
	      case 5:
	    	  
	    	  	System.out.println("Entrez un nom d'article : ");
	    	  	lecteur.nextLine();
		    	nom = lecteur.nextLine();
		    	
		    	if (searchPerName(stock, nom) == null) {
		    		System.out.println("Le stock n'a pas d'article avec ce nom!");
		    		break;
		    	} else {
		    		display(searchPerName(stock, nom));
		    		break;
		    	}

	      case 6:
	    	  
	    	  System.out.println("Entrez le prix minimum : ");
	    	  min = lecteur.nextDouble();
	    	  
	    	  System.out.println("Entrez le prix maximum : ");
	    	  max = lecteur.nextDouble();
	    	  lecteur.nextLine();

	    	  if (searchPerPriceInterval(stock, min, max) == null) {
	    		  System.out.println("Pas d'articles dans cet intervalle de prix!");
	    		  break;
	    	  } else {
	    		  display(searchPerPriceInterval(stock, min, max));
	    		  break;
	    	  }
	    	  
	      case 7:
	    	  
	      display(stock);
	      lecteur.nextLine();
	      break;
	      
	      case 8:
	    	  System.out.println("Bye bye!");
	    	  lecteur.close();
	    	  return;

	      default:
	        System.out.printf("Erreur! Votre choix %s n'est pas correct!", choix);
	        lecteur.nextLine();
	        //lecteur.close();
	        break;
	   
		}
		
		System.out.println("Voulez-vous continuer (O/N)?");
		
		reponse = lecteur.nextLine();
		
		
		if (reponse.equals("o") || reponse.equals("O")) {
			continuer = true;
		} else {
			continuer = false;
		}
		
		 }
		
		while (continuer == true);
		
		System.out.println("Bye bye!");
		lecteur.close();

	}
	
}
