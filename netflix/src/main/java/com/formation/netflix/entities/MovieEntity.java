package com.formation.netflix.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_movie;

    @OneToMany(mappedBy = "movieEntity", cascade = CascadeType.ALL)
    private List<RoleEntity> roleListOfMovie;



}
