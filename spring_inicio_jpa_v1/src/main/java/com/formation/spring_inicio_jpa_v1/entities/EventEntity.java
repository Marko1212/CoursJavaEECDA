package com.formation.spring_inicio_jpa_v1.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Calendar;

@Data
@NoArgsConstructor
@Entity
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String title;
    private String description;
    @Temporal(TemporalType.DATE)
    @ToString.Exclude
    private Calendar beginDate;
    private boolean allDay;


}
