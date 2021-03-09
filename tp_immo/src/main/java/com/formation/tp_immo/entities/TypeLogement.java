package com.formation.tp_immo.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class TypeLogement {
    @Id
    @Column(nullable = false, length = 20)
    private String type;

    @NonNull
    private double chargesForfaitaires;

    public TypeLogement(String type, @NonNull double chargesForfaitaires) {
        this.type = type;
        this.chargesForfaitaires = chargesForfaitaires;
    }

    @OneToMany(mappedBy="typeLogement", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Logement> logements = new ArrayList<>();


}
