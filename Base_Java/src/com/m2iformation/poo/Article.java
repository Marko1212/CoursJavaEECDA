package com.m2iformation.poo;

public class Article {

	private int numeroReference;
	private String nom;
	private double prix;
	private int quantiteStock;
	
	public Article() {
		
	}

	public Article(int numeroReference, String nom, double prix, int quantiteStock) {
		super();
		this.numeroReference = numeroReference;
		this.nom = nom;
		this.prix = prix;
		this.quantiteStock = quantiteStock;
	}

	public int getNumeroReference() {
		return numeroReference;
	}

	public void setNumeroReference(int numeroReference) {
		this.numeroReference = numeroReference;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getQuantiteStock() {
		return quantiteStock;
	}

	public void setQuantiteStock(int quantiteStock) {
		this.quantiteStock = quantiteStock;
	}

	@Override
	public String toString() {
		return "Article [numeroReference=" + numeroReference + ", nom=" + nom + ", prix=" + prix + ", quantiteStock="
				+ quantiteStock + "]";
	}
	

}
