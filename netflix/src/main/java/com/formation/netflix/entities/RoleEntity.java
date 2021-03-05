package com.formation.netflix.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String character;

    @ManyToMany(mappedBy = "roleListOfMovie")
    private List<MovieEntity> movieList;

    @ManyToMany(mappedBy = "roleListOfActor")
    private List<ActorEntity> actorList;

}
