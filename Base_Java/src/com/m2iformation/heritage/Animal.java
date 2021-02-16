package com.m2iformation.heritage;

public abstract class Animal implements IAnimalAction {
	private Couleur couleur;
	private String race;
	private int age;
	private String nom;
	private float poids;
	
	public Animal() {
		
	}

	public Animal(Couleur couleur, String race, int age, String nom, float poids) {
		this.couleur = couleur;
		this.race = race;
		this.age = age;
		this.nom = nom;
		this.poids = poids;
	}
	
	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	@Override
	public String toString() {
		return "Animal [couleur=" + couleur + ", race=" + race + ", age=" + age + ", nom=" + nom + ", poids=" + poids
				+ "]";
	}
	
	
}


