package com.m2iformation.poo;

public class Societe {
	
	private String nom;
	private Adresse loc;
	

	

	public String getNom() {
		return nom;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public Adresse getLoc() {
		return loc;
	}




	public void setLoc(Adresse loc) {
		this.loc = loc;
	}




	@Override
	public String toString() {
		return "Societe [nom=" + nom + ", loc=" + loc + "]";
	}


	
	
	
}