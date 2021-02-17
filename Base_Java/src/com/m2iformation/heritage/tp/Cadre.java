package com.m2iformation.heritage.tp;


public class Cadre extends Employe {
	
	private int indice;
	
	public Cadre() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Cadre(String nom, String prenom, String dateNaissance, int indice) {
		super(nom, prenom, dateNaissance);
		this.indice = indice;
		// TODO Auto-generated constructor stub
	}
	

	public int getIndice() {
		return indice;
	}



	public void setIndice(int indice) {
		this.indice = indice;
	}



	@Override
	public double getSalaire() {

		double salaire = 0;
		
		switch(indice) {
		  case 1:
		    salaire = 1400;
		    break;
		  case 2:
		    salaire = 2000;
		    break;
		  case 3:
			salaire = 2300;
			break;
		  case 4:
			salaire = 3000;
			break;
	}
		
		return salaire;
	}
	
	
	
	@Override
	public String toString() {
		return "Cadre : " + super.toString() + " indice : " + indice;
	}

}
