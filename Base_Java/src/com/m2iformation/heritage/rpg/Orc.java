package com.m2iformation.heritage.rpg;

public class Orc extends Personnage implements IChaman, IChasseur {

	public Orc() {
		super();
		// TODO Auto-generated constructor stub
		
		force = IChaman.FORCE_ORC + IChasseur.FORCE_ORC;
		endurance = IChaman.ENDURANCE_ORC + IChasseur.ENDURANCE_ORC;
		agilite = IChaman.AGILITE_ORC + IChasseur.ENDURANCE_ORC;
	}


	@Override
	public String toString() {
		return "Orc : " + super.toString();
	}
	
	

}
