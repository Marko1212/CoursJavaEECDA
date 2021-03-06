package com.m2iformation.poo.ecole;

public class Eleve {
	
	private String nomEleve;
	private String prenomEleve;
	private int ageEleve;
	private int anneeCoursSuivieEleve;

	
	public Eleve(String nomEleve, String prenomEleve, int ageEleve, int anneeCoursSuivieEleve) {
		super();
		this.nomEleve = nomEleve;
		this.prenomEleve = prenomEleve;
		this.ageEleve = ageEleve;
		this.anneeCoursSuivieEleve = anneeCoursSuivieEleve;
	}

	public String getNomEleve() {
		return nomEleve;
	}

	public void setNomEleve(String nomEleve) {
		this.nomEleve = nomEleve;
	}

	public String getPrenomEleve() {
		return prenomEleve;
	}

	public void setPrenomEleve(String prenomEleve) {
		this.prenomEleve = prenomEleve;
	}

	public int getAgeEleve() {
		return ageEleve;
	}

	public void setAgeEleve(int ageEleve) {
		this.ageEleve = ageEleve;
	}

	public int getAnneeCoursSuivieEleve() {
		return anneeCoursSuivieEleve;
	}

	public void setAnneeCoursSuivieEleve(int anneeCoursSuivieEleve) {
		this.anneeCoursSuivieEleve = anneeCoursSuivieEleve;
	}

	@Override
	public String toString() {
		return "Eleve [nomEleve=" + nomEleve + ", prenomEleve=" + prenomEleve + ", ageEleve=" + ageEleve
				+ ", anneeCoursSuivieEleve=" + anneeCoursSuivieEleve + "]";
	}
	
	
}
