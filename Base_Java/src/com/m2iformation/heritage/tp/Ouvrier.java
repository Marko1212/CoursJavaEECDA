package com.m2iformation.heritage.tp;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Ouvrier extends Employe {
	
	private static final double SMIG = 1300;
	
	private String dateEntree;
	
	//LocalDate dateEntree = LocalDate.of(2021, 2, 26);

	public Ouvrier() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Ouvrier(String nom, String prenom, String dateNaissance, String dateEntree) {
		super(nom, prenom, dateNaissance);
		this.dateEntree = dateEntree;
		// TODO Auto-generated constructor stub
	}

	public String getDateEntree() {
		return dateEntree;
	}



	public void setDateEntree(String dateEntree) {
		this.dateEntree = dateEntree;
	}


	public static double getSmig() {
		return SMIG;
	}



	@Override
	public double getSalaire() {
		// TODO Auto-generated method stub
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate dateEntreeFormatee = LocalDate.parse(dateEntree, formatter);
	
		
	int differenceInYears = Period.between(dateEntreeFormatee, LocalDate.now()).getYears();
	    System.out.println(differenceInYears);
		
		return (SMIG + 20 * differenceInYears) <= 2*SMIG ? (SMIG + 20 * differenceInYears) : 2 * SMIG;
	}


	@Override
	public String toString() {
		return "Ouvrier : " + super.toString() + " date d'entrée : " + dateEntree;
	}



	
	
	

}
