package com.formation.inicio_jpa_v2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String login;
    private String pass;
    private String email;

    @OneToMany(mappedBy="userEntity", cascade = CascadeType.ALL)
    private List<EventEntity> eventList;




}
