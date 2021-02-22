package com.m2iformation.exceptions;

public class FeuSignalisation {
	
	private String colorOfLight = "green";
	
	
	
	public String getColorOfLight() {
		return colorOfLight;
	}


	public void changeColor(String color) throws FeuSignalisationException {
		
		if (color.toLowerCase() == "red" || color.toLowerCase() == "green" || color.toLowerCase() == "yellow") {
			this.colorOfLight = color;
			return;
		}
	
		throw new FeuSignalisationException("Le feu ne peut pas avoir cette couleur!");
		
	}

}
