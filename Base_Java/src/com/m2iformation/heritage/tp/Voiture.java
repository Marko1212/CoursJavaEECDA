package com.m2iformation.heritage.tp;

public class Voiture extends Vehicule {

	public Voiture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Voiture(int anneeModele, double prix) {
		super(anneeModele, prix);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void demarrer() {
		// TODO Auto-generated method stub
		System.out.println("La voiture démarre!");
		
	}

	@Override
	public void accelerer() {
		// TODO Auto-generated method stub
		System.out.println("La voiture accélère!");
		
	}

	@Override
	public String toString() {
		return "Voiture : " + super.toString();
	}

	
	

}
