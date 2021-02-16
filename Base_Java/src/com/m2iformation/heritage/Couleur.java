package com.m2iformation.heritage;

public enum Couleur {
	BLANC("#ecf9f1", "rgb(236, 240, 241)"), NOIR("#2ce50", "rgb(44, 62, 80)"), ROUX("#d35400", "rgb(211, 84, 0)"), MARRON("#61471f", "rgb(97, 71, 31)"), GRIS("#bdc3c7", "rgb(189, 195, 199)"), FAUVE("#eccc68", "rgb(236, 204, 104)");
	
	private String hex;
	private String rgb;
	
	Couleur(String hex, String rgb) {
		this.hex = hex;
		this.rgb = rgb;
	}
	
	public String getHex() {
		return hex;
	}
	
	public String getRgb() {
		return rgb;
	}
	
}
