package com.m2iformation.heritage;

public interface IAnimalAction {
	
	final String str = "";
	
	void crier();
	
	void manger();
	
	void dormir();
	
	default void bouger() {
		System.out.println("je marche");
	}

}
