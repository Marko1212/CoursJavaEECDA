package com.formation.spring_inicio_jpa_v1.repositories;

import com.formation.spring_inicio_jpa_v1.entities.EventEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<EventEntity, Integer> {
}
