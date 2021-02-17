package com.m2iformation.heritage.tp;

public class Camion extends Vehicule {
	
	public Camion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Camion(int anneeModele, double prix) {
		super(anneeModele, prix);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void demarrer() {
		// TODO Auto-generated method stub
		System.out.println("Le camion démarre!");
		
	}

	@Override
	public void accelerer() {
		// TODO Auto-generated method stub
		System.out.println("Le camion accélère!");
		
	}

	@Override
	public String toString() {
		return "Camion : " + super.toString();
	}


}
