package com.m2iformation.jdbcVilles.models;

import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Ville {
	
	@NonNull
	private Integer id;
	@NonNull
	private String departement;
	private String slug;
	private String nom;
	private String nomSimple;
	private String nomReel;
	private String nomSoundex;
	private String nomMetaphone;
	private String codePostal;
	private String numCommune;
	private String codeCommune;
	private String arrondissement;
	private String canton;
	private String amdi;
	private String pop2010;
	private String pop1999;
	private String pop2012;
	private String densite2010;
	private String surface;
	private String longitudeDeg;
	private String latitudeDeg;
	private String longitudeGRD;
	private String latitudeGRD;
	private String longitudeDMS;
	private String latitudeDMS;
	private String zMin;
	private String zMax;

	/**
	 * Cette méthode récupère une ligne de String contenant les informations d'une ville puis
	 * renvoie un objet Ville avec ses propriétés correspondantes
	 * @param lineCsv : ligne contenant les infos d'une ville
	 * @return une ville avec ses propriétés complétées
	 */
	public Ville stringToField(String lineCsv) {
		lineCsv = lineCsv.replaceAll("\"", "");
		String[] tab = lineCsv.split(",");
		this.id = Integer.parseInt(tab[0]);
		this.departement = tab[1].trim();
		this.slug = tab[2].trim();
		this.nom = tab[3].trim();
		this.nomSimple = tab[4].trim();
		this.nomReel = tab[5].trim();
		this.nomSoundex = tab[6].trim();
		this.nomMetaphone = tab[7].trim();
		this.codePostal = tab[8].trim();
		this.numCommune = tab[9].trim();
		this.codeCommune = tab[10].trim();
		this.arrondissement = tab[11].trim();
		this.canton = tab[12].trim();
		this.amdi = tab[13].trim();
		this.pop2010 = tab[14].trim();
		this.pop1999 = tab[15].trim();
		this.pop2012 = tab[16].trim();
		this.densite2010 = tab[17].trim();
		this.surface = tab[18].trim();
		this.longitudeDeg = tab[19].trim();
		this.latitudeDeg = tab[20].trim();
		this.longitudeGRD = tab[21].trim();
		this.latitudeGRD = tab[22].trim();
		this.longitudeDMS = tab[23].trim();
		this.latitudeDMS = tab[24].trim();
		this.zMin = tab[25].trim();
		this.zMax = tab[26].trim();
		return this;
	}

	/**
	 * Cette méthode renvoie notre en objet en Chaine de caractères afin de l'écrire
	 * dans une ligne de fichier csv (donc formatée)
	 * @return ligne formatée pour notre fichier CSV
	 */
	public String objectToCsv() {
		return id + ';' + departement + ';' + slug + ';' + nom + ';' +
				nomSimple + ';' + nomReel + ';' + nomSoundex + ';' + nomMetaphone + ';' +
				codePostal + ';' + numCommune + ';' + codeCommune + ';' +
				arrondissement + ';' + canton + ';' + amdi + ';' + pop2010 + ';' +
				pop1999 + ';' + pop2012 + ';' + densite2010 + ';' + surface + ';' +
				longitudeDeg + ';' + latitudeDeg + ';' + longitudeGRD + ';' + latitudeGRD + ';' +
				longitudeDMS + ';' + latitudeDMS + ';' +
				zMin + ';' + zMax;
	}
}
