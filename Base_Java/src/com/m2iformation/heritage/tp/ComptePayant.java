package com.m2iformation.heritage.tp;

public class ComptePayant extends Compte {

	 public ComptePayant(double solde){
	 super(solde);
	 }
	 
	 public ComptePayant() {
	 super(0);
	 }
	 
	 public void deposer(double montant){
	 super.deposer(montant);
	 super.retirer(0.5);
	 }
	 public void retirer(double montant){
	 super.retirer(montant);
	 super.retirer(0.5);
	 }
	 
	 public String toString() {
	 return "Compte Payant : " + super.toString();
	 }
	 
	}

