package com.m2iformation.heritage;

public class Chat extends Animal {
	
	Chat(){
		super("noir", "gouttière", 1, "gros minet", 5);
	}
	
	Chat(String couleur, String race, int age, String nom, float poids) {
		super(couleur, race, age, nom, poids);
	}

	@Override
	public void crier() {
		// TODO Auto-generated method stub
		System.out.println("Je miaule");
	}

	@Override
	public void manger() {
		// TODO Auto-generated method stub
		System.out.println("Je mange des croquettes");
	}

	@Override
	public void dormir() {
		// TODO Auto-generated method stub
		System.out.println("Je dors 18h");
	}
	
	
	
}
