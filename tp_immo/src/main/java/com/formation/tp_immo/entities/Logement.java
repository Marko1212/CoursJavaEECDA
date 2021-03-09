package com.formation.tp_immo.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor

@Entity
public class Logement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String num;

    @NonNull
    private String rue;

    @NonNull
    private double superficie;

    @NonNull
    private double loyer;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private TypeLogement typeLogement;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private Quartier quartier;

    @OneToMany(mappedBy = "logement", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Individu> individus = new ArrayList<>();

    public void addIndividu(Individu individu) {
        this.individus.add(individu);
    }

    public void removeIndividu(Individu individu) {
        this.individus.remove(individu);
    }



}
