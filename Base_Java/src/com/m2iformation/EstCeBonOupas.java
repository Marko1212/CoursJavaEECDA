package com.m2iformation;

class EstCeBonOupas {
private String monPrénom = "Samuel";
private String monAge = "39 ans";
private String monNom = "Michaux";

public EstCeBonOupas(String mon_prénom, String mon_age) {
this.monPrénom = mon_prénom;
this.monAge = mon_age;
}
public EstCeBonOupas(String mon_prénom, String mon_age, String
mon_nom) {
this.monPrénom = mon_prénom;
this.monAge = mon_age;
this.monNom = mon_nom;
}
@Override
public String toString() {
return "EstCeBonOupas{" +
"monPrénom='" + monPrénom + '\'' +
", monAge='" + monAge + '\'' +
", monNom='" + monNom + '\'' + 
'}';
}
public static void main(String... args){
System.out.println(new EstCeBonOupas("Toto", "44"));
System.out.println(new EstCeBonOupas("Toto", "44", "Titi"));

}
}
