package com.m2iformation.heritage.tp;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Voiture voiture = new Voiture(2012,80000);
        System.out.println(voiture);
        voiture.demarrer();
        voiture.accelerer();
        Camion camion = new Camion(2016, 3000000);
        System.out.println(camion);
        camion.demarrer();
        camion.accelerer();
        
        Camion camion2 = new Camion(2017, 2500000);
        System.out.println(camion2);
        camion2.demarrer();
        camion2.accelerer();
        
        Voiture voiture2 = new Voiture(2008,50000);
        System.out.println(voiture2);
        voiture2.demarrer();
        voiture2.accelerer();
        
	}

}
