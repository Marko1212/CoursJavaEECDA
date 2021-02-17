package com.m2iformation.heritage.tp;

import java.time.*;

public class Ouvrier extends Employe {
	
	private static final double SMIG = 1300;
	
	private LocalDate dateEntree;
	
	//LocalDate dateEntree = LocalDate.of(2021, 2, 26);

	public Ouvrier() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Ouvrier(String nom, String prenom, String dateNaissance, LocalDate dateEntree) {
		super(nom, prenom, dateNaissance);
		this.dateEntree = dateEntree;
		// TODO Auto-generated constructor stub
	}

	public LocalDate getDateEntree() {
		return dateEntree;
	}



	public void setDateEntree(LocalDate dateEntree) {
		this.dateEntree = dateEntree;
	}


	public static double getSmig() {
		return SMIG;
	}



	@Override
	public double getSalaire() {
		// TODO Auto-generated method stub
		
	int differenceInYears = Period.between(dateEntree, LocalDate.now()).getYears();
	    System.out.println(differenceInYears);
		
		return (SMIG + 20 * differenceInYears) <= 2*SMIG ? (SMIG + 20 * differenceInYears) : 2 * SMIG;
	}


	@Override
	public String toString() {
		return "Ouvrier : " + super.toString() + " date d'entrée : " + dateEntree;
	}



	
	
	

}
