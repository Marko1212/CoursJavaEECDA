package com.m2iformation.heritage.tp;

public abstract class Vehicule {
	
	private int matricule;
	private int anneeModele;
	private double prix;
	
	private static int nbVehicules = 0;

	public Vehicule() {
	}

	public Vehicule(int anneeModele, double prix) {
		nbVehicules++;
		this.matricule = nbVehicules;
		this.anneeModele = anneeModele;
		this.prix = prix;
	}

	public int getMatricule() {
		return matricule;
	}

	public int getAnneeModele() {
		return anneeModele;
	}

	public void setAnneeModele(int anneeModele) {
		this.anneeModele = anneeModele;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public static int getNbVehicules() {
		return nbVehicules;
	}
	
    public abstract void demarrer();
    public abstract void accelerer();

	@Override
	public String toString() {
		return "Vehicule [matricule=" + matricule + ", anneeModele=" + anneeModele + ", prix=" + prix + "]";
	}
	
    
}
