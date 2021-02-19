package com.m2iformation.heritage.rpg;

public abstract class Personnage {
	
 protected int force;
 
 protected double endurance;
 
 protected int agilite;

public Personnage(int force, double endurance, int agilite) {

	this.force = force;
	this.endurance = endurance;
	this.agilite = agilite;
}

public int getForce() {
	return force;
}

public void setForce(int force) {
	this.force = force;
}

public double getEndurance() {
	return endurance;
}

public void setEndurance(double endurance) {
	this.endurance = endurance;
}

public int getAgilite() {
	return agilite;
}

public void setAgilite(int agilite) {
	this.agilite = agilite;
}

public void attaquer(Personnage cible) {
	double nbDegats = 1/10 * force + 1/10 * agilite;
	endurance++;
	agilite--;
	cible.recevoirDegats(nbDegats);
	
}

public void recevoirDegats(double nbDegats) {
	endurance -= nbDegats;
	agilite++;
}

@Override
public String toString() {
	return "Personnage [force=" + force + ", endurance=" + endurance + ", agilite=" + agilite + "]";
}
 
 
 
}
