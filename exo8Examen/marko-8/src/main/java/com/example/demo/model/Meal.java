package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(	name = "meals" )
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mealId;
    private String titre;
    private String lienImage;
    private String preparation;
    private String cuisson;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "mealId", referencedColumnName = "mealId")
    private List<Ingredient> ingredients;

    @Override
    public String toString() {
        return "Meal{" +
                "mealId=" + mealId +
                ", titre='" + titre + '\'' +
                ", lienImage='" + lienImage + '\'' +
                ", preparation='" + preparation + '\'' +
                ", cuisson='" + cuisson + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getLienImage() {
        return lienImage;
    }

    public void setLienImage(String lienImage) {
        this.lienImage = lienImage;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public String getCuisson() {
        return cuisson;
    }

    public void setCuisson(String cuisson) {
        this.cuisson = cuisson;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Meal() {
    }

    public Meal(int mealId, String titre, String lienImage, String preparation, String cuisson, List<Ingredient> ingredients) {
        this.mealId = mealId;
        this.titre = titre;
        this.lienImage = lienImage;
        this.preparation = preparation;
        this.cuisson = cuisson;
        this.ingredients = ingredients;
    }
}
