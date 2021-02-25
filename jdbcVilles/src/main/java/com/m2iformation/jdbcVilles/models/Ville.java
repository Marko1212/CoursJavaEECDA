package com.m2iformation.jdbcVilles.models;

import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//@Getter
//@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Ville {
	
	@NonNull
	private int id;
	
	@NonNull
	private String departement;
	
	private String slug;
	private String nom;
	private String nomSimple;
	private String nomReel;
	private String nomSoundex;
	private String nomMetaphore;
	private String codePostal;
	private String numeroDeCommune;
	private String codeCommune;
	private String arrondissement;
	private String canton;
	private String amdi;
	private String population2010;
	private String population1999;
	private String population2012;
	private String densite2010;
	private String superficie;
	private String longitudeDeg;
	private String latitudeDeg;
	private String longitudeGrd;
	private String latitudeGrd;
	private String longitudeDms;
	private String latitudeDms;
	private String altitudeMin;
	private String altitudeMax;
	
	
	
	public String toFile() {
		return id + "," + departement + "," + slug + "," + nom + "," + nomSimple + "," + nomReel +"," + nomSoundex + ","
				+ nomMetaphore +"," + codePostal + "," + numeroDeCommune + "," + codeCommune + "," + arrondissement + ","
				+ canton + "," + amdi + "," + population2010 + "," + population1999 + "," + population2012 + "," + densite2010
				+ "," + superficie + "," + longitudeDeg + "," + latitudeDeg + "," + longitudeGrd + "," + latitudeGrd + "," +
				longitudeDms + "," + latitudeDms + "," + altitudeMin + "," + altitudeMax;
	}
}
