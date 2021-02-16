package com.m2iformation.heritage;

public class Cheval extends Animal {
	private String couleur;
	private String race;
	private int age;
	private String nom;
	private float poids;
	
	public void crier() {
		System.out.println("j'hennis");
	}

	public void manger() {
		System.out.println("je mange des carottes");
	}
	
	public void dormir() {
		System.out.println("je dors en moyenne 10 heures");
	}

}
