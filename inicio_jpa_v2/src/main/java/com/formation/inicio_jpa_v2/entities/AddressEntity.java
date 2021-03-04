package com.formation.inicio_jpa_v2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AddressEntity {

    @Id
    private Integer id;

    private String name;
    private String street;
    private String comments;
    private String zipCode;
    private String city;




}
