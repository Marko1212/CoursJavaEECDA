package com.formation.netflix.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class ActorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_actor;

    @NonNull
    private String name;
    @NonNull
    private String address;


    @OneToMany(mappedBy = "actorEntity", cascade = CascadeType.ALL)
    private List<RoleEntity> roleListOfActor;

}
