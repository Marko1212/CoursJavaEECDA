package com.m2iformation.heritage;

public class Chat extends Animal {
	
	Chat(){
		super("noir", "gouttière", 1, "gros minet", 5);
	}
	
	Chat(String couleur, String race, int age, String nom, float poids) {
		super(couleur, race, age, nom, poids);
	}
	
}
