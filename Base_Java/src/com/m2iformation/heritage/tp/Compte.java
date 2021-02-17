package com.m2iformation.heritage.tp;

public class Compte {
	
	int code;
	double solde;
	static int nbComptes=0;
	
	public Compte(double solde){
	 this.solde=solde;
	 ++nbComptes;
	 this.code=nbComptes;
	}
	public Compte(){
	 this(0);
	}
	public void deposer(double montant){
	 this.solde += montant;
	}
	public void retirer(double montant){
	 this.solde -= montant;
	}
	@Override
	public String toString() {
		return "Compte [code=" + code + ", solde=" + solde + "]";
	}

}

