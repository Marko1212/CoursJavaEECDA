package com.formation.netflix.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor

@Entity
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movie_id;

    @NonNull
    private String title;

    @ManyToMany(mappedBy = "movieEntities")
    private List<RoleEntity> rolesOfMovie = new ArrayList<>();

    public void addRole(RoleEntity role) {
        this.rolesOfMovie.add(role);
        role.getMovieEntities().add(this);
    }

    public void removeRole(RoleEntity role) {
        this.rolesOfMovie.remove(role);
        role.getMovieEntities().remove(this);
    }



}
