package com.m2iformation.heritage.tp;

public abstract class Employe {
	
	private String nom;
    private String prenom;
    private String dateNaissance;
    private int matricule;
    
    private static int nbEmployes=0;
    
    public Employe() {
    	nbEmployes++;
    	matricule = nbEmployes;
	}
    
    public Employe(String nom, String prenom, String dateNaissance) {
    	nbEmployes++;
    	matricule = nbEmployes;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public abstract double getSalaire();

	@Override
	public String toString() {
		return "Employe [nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", matricule="
				+ matricule + "]";
	}


}
