package com.formation.netflix.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
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
    private Set<RoleEntity> rolesOfActor = new HashSet<>();

    public void addRole(RoleEntity role) {
        this.rolesOfActor.add(role);
        role.getActorEntities().add(this);
    }

    public void removeRole(RoleEntity role) {
        this.rolesOfActor.remove(role);
        role.getActorEntities().remove(this);
    }

}
