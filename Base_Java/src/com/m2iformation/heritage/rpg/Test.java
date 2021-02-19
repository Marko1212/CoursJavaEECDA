package com.m2iformation.heritage.rpg;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Elfe elfe = new Elfe();
		
		Orc orc = new Orc();
		
		System.out.println(elfe);
		
		System.out.println(orc);
		
		elfe.attaquer(orc);
		
		System.out.println(orc);
		
		System.out.println(elfe);

	}

}
