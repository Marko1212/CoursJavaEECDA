package com.m2iformation.heritage;

public class Chien extends Animal {
	private String couleur;
	private String race;
	private int age;
	private String nom;
	private float poids;
	
	public void crier() {
		System.out.println("j'aboie");
	}

	public void manger() {
		System.out.println("je mange des croquettes");
	}
	
	public void dormir() {
		System.out.println("je dors en moyenne 12 heures");
	}

}
