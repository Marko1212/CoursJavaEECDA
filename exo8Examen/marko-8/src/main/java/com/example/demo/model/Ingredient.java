package com.example.demo.model;

import javax.persistence.*;


@Entity
@Table(	name = "ingredients" )
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ingredientId;
    private int nombre;
    private String unite;
    private String nom;

    @Column(name = "mealId", insertable = false, nullable = true)
    private int mealId;

    public Ingredient(int nombre, String s, String s1) {
        this.nombre = nombre;
        this.unite = s;
        this.nom = s1;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientId=" + ingredientId +
                ", nombre=" + nombre +
                ", unite='" + unite + '\'' +
                ", nom='" + nom + '\'' +
                ", mealId=" + mealId +
                '}';
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
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

    public Ingredient() {
    }


}
