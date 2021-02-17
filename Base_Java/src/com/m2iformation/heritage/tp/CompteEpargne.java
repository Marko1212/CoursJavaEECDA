package com.m2iformation.heritage.tp;

public class CompteEpargne extends Compte {

double tauxInteret = 1.8;

public CompteEpargne(double solde){
 super(solde);
}
public CompteEpargne(){
 super(0);
}

public void calculInteret(){
	 solde=solde*(1+tauxInteret/100);
}

public String toString(){
	
 return "Compte Epargne : " + super.toString() + " taux d'intérêt = " + tauxInteret;
}

}
