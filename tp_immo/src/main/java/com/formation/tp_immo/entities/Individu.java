package com.formation.tp_immo.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Individu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String lastName;

    @NonNull
    private String firstName;

    @Temporal(TemporalType.DATE)
    @ToString.Exclude
    @NonNull
    private Calendar dateOfBirth ;

    @NonNull
    private String phoneNumber;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private Logement logement;



}
