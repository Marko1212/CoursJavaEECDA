package com.formation.netflix.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer role_id;

    @NonNull
    private String featuredCharacter;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinTable(
            name = "role_movie",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name= "movie_id")
    )
    private List<MovieEntity> movieEntities = new ArrayList<>();


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinTable(
            name = "role_actor",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name= "actor_id")
    )
    private List<ActorEntity> actorEntities = new ArrayList<>();


}
