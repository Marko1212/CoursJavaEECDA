package com.example.demo.request_model;

public class RequestMeal {
    private String titre;
    private String lienImage;
    private String preparation;
    private String cuisson;

    @Override
    public String toString() {
        return "RequestMeal{" +
                "titre='" + titre + '\'' +
                ", lienImage='" + lienImage + '\'' +
                ", preparation='" + preparation + '\'' +
                ", cuisson='" + cuisson + '\'' +
                '}';
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


    public RequestMeal() {
    }

    public RequestMeal(String titre, String lienImage, String preparation, String cuisson) {
        this.titre = titre;
        this.lienImage = lienImage;
        this.preparation = preparation;
        this.cuisson = cuisson;

    }
}
