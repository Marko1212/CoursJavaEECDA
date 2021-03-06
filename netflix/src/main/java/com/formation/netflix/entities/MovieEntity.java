package com.formation.netflix.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movie_id;

    @ManyToMany(mappedBy = "movieEntities")
    private Set<RoleEntity> rolesOfMovie = new HashSet<>();

    public void addRole(RoleEntity role) {
        this.rolesOfMovie.add(role);
        role.getMovieEntities().add(this);
    }

    public void removeRole(RoleEntity role) {
        this.rolesOfMovie.remove(role);
        role.getMovieEntities().remove(this);
    }



}
