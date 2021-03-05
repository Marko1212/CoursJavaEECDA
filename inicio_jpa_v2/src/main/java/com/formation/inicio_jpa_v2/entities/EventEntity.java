package com.formation.inicio_jpa_v2.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NonNull
    private String title;

    @NonNull
    @Column(columnDefinition = "TEXT")
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "event_guest",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name= "guest_id")
    )
    private List<GuestEntity> guestList;

    @OneToMany(mappedBy = "eventEntity")
    private List<ItemEntity> itemList;

    public EventEntity(@NonNull String title, @NonNull String description, @NonNull Calendar beginDate, @NonNull boolean allDay, UserEntity userEntity) {
        this.title = title;
        this.description = description;
        this.beginDate = beginDate;
        this.allDay = allDay;
        this.userEntity = userEntity;
    }
}
