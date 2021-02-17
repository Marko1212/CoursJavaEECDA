package com.m2iformation.heritage.tp;

import java.time.LocalDate;

public class TestExercice3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ouvrier ouvrier = new Ouvrier("Dupont", "Pierre", "02/03/1930", "01/03/1950");
		
		
		Cadre cadre = new Cadre("Nadal", "Rafael", "05/05/1980", 4);
		
		
		Patron patron = new Patron("Tsitsipas", "Stefanos", "08/09/1990", 50);
		
		System.out.println(ouvrier);
		System.out.println(cadre);
		System.out.println(patron);
		
		System.out.println(ouvrier.getSalaire());
		
		System.out.println(cadre.getSalaire());
		
		System.out.println(patron.getSalaire());
		
		
		
		

	}

}
