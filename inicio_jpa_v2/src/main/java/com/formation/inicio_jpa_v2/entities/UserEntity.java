package com.formation.inicio_jpa_v2.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @Pattern(regexp = "^[a-z0-9À-ÿ]{3,100}$",
            flags= {Pattern.Flag.CASE_INSENSITIVE},
            message="Tu ne peux mettre que 3 à 100 lettres / chiffres. Tu n'as pas le droit de mettre des caractères spéciaux.")
    private String login;

    @Size(min = 8, max = 64)
    @NotNull
    private String pass;

    @Email(message = "Ton email n'est pas valide")
    @NotNull
    private String email;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<EventEntity> eventList;


}
