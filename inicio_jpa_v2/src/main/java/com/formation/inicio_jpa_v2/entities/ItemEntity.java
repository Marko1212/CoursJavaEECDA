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
public class ItemEntity {
    @Id
    private Integer id;

    private String name;
    private Integer neededQuantity;
    private Integer currentQuantity;



}
