package com.example.demo.request_model;


public class RequestIngredient {

    private int nombre;
    private String unite;
    private String nom;

    private int mealId;

    @Override
    public String toString() {
        return "RequestIngredient{" +
                "nombre=" + nombre +
                ", unite='" + unite + '\'' +
                ", nom='" + nom + '\'' +
                ", mealId=" + mealId +
                '}';
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public RequestIngredient() {
    }

    public RequestIngredient(int nombre, String unite, String nom, int mealId) {
        this.nombre = nombre;
        this.unite = unite;
        this.nom = nom;
        this.mealId = mealId;
    }
}
