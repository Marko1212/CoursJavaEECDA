package com.m2iformation.heritage.tp;

public class Patron extends Employe {
	
	private static final double chiffreAffaires = 1000000;
	
	private double pourcentage;
	
	public Patron() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patron(String nom, String prenom, String dateNaissance, double pourcentage) {
		super(nom, prenom, dateNaissance);
		this.pourcentage = pourcentage;
		// TODO Auto-generated constructor stub
	}
	

	public static double getChiffreAffaires() {
		return chiffreAffaires;
	}

	public double getPourcentage() {
		return pourcentage;
	}

	public void setPourcentage(double pourcentage) {
		this.pourcentage = pourcentage;
	}

	@Override
	public double getSalaire() {
		// TODO Auto-generated method stub
		
		// salaire mensuel donc division par 12
		return chiffreAffaires*pourcentage / (100 * 12);
	}
	
	@Override
	public String toString() {
		return "Patron : " + super.toString() + " pourcentage : " + pourcentage;
	}

	
}
