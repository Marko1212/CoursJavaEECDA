package com.m2iformation.jdbcVilles.models;

import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
@Data
public class Ville {
	
	private int id;
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
	
	
	
	
	public Ville() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ville(int id, String departement, String slug, String nom, String nomSimple, String nomReel, String nomSoundex,
			String nomMetaphore, String codePostal, String numeroDeCommune, String codeCommune, String arrondissement,
			String canton, String amdi, String population2010, String population1999, String population2012,
			String densite2010, String superficie, String longitudeDeg, String latitudeDeg, String longitudeGrd,
			String latitudeGrd, String longitudeDms, String latitudeDms, String altitudeMin, String altitudeMax) {
		super();
		this.id = id;
		this.departement = departement;
		this.slug = slug;
		this.nom = nom;
		this.nomSimple = nomSimple;
		this.nomReel = nomReel;
		this.nomSoundex = nomSoundex;
		this.nomMetaphore = nomMetaphore;
		this.codePostal = codePostal;
		this.numeroDeCommune = numeroDeCommune;
		this.codeCommune = codeCommune;
		this.arrondissement = arrondissement;
		this.canton = canton;
		this.amdi = amdi;
		this.population2010 = population2010;
		this.population1999 = population1999;
		this.population2012 = population2012;
		this.densite2010 = densite2010;
		this.superficie = superficie;
		this.longitudeDeg = longitudeDeg;
		this.latitudeDeg = latitudeDeg;
		this.longitudeGrd = longitudeGrd;
		this.latitudeGrd = latitudeGrd;
		this.longitudeDms = longitudeDms;
		this.latitudeDms = latitudeDms;
		this.altitudeMin = altitudeMin;
		this.altitudeMax = altitudeMax;
	}
	
	
	public String toFile() {
		return id + "," + departement + "," + slug + "," + nom + "," + nomSimple + "," + nomReel +"," + nomSoundex + ","
				+ nomMetaphore +"," + codePostal + "," + numeroDeCommune + "," + codeCommune + "," + arrondissement + ","
				+ canton + "," + amdi + "," + population2010 + "," + population1999 + "," + population2012 + "," + densite2010
				+ "," + superficie + "," + longitudeDeg + "," + latitudeDeg + "," + longitudeGrd + "," + latitudeGrd + "," +
				longitudeDms + "," + latitudeDms + "," + altitudeMin + "," + altitudeMax;
	}
}
