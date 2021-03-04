package com.formation.inicio_jpa_v2.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NonNull
    private String title;

    @NonNull
    private String description;

    @Temporal(TemporalType.DATE)
    @ToString.Exclude
    @NonNull
    private Calendar beginDate;

    @NonNull
    private boolean allDay;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @ToString.Exclude
    private AddressEntity addressEntity;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    private UserEntity userEntity;
}
