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
public class ActorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actor_id;

    @NonNull
    private String name;
    @NonNull
    private String address;

    @ManyToMany(mappedBy = "actorEntities")
    private List<RoleEntity> rolesOfActor = new ArrayList<>();

    public void addRole(RoleEntity role) {
        this.rolesOfActor.add(role);
        role.getActorEntities().add(this);
    }

    public void removeRole(RoleEntity role) {
        this.rolesOfActor.remove(role);
        role.getActorEntities().remove(this);
    }

}
