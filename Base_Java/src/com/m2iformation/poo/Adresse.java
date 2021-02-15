package com.m2iformation.poo;

public class Adresse {
	
	private String nomRue;
	private int numeroRue;
	private String nomVille;
	
	public Adresse(String nomRue, int numeroRue, String nomVille) {
		super();
		this.nomRue = nomRue;
		this.numeroRue = numeroRue;
		this.nomVille = nomVille;
	}
	
	
	public String getNomRue() {
		return nomRue;
	}
	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}
	public int getNumeroRue() {
		return numeroRue;
	}
	public void setNumeroRue(int numeroRue) {
		this.numeroRue = numeroRue;
	}
	public String getNomVille() {
		return nomVille;
	}
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	@Override
	public String toString() {
		return "Adresse [nomRue=" + nomRue + ", numeroRue=" + numeroRue + ", nomVille=" + nomVille + "]";
	}
	

}
