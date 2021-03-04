package com.formation.spring_inicio_jpa_v1.repositories;

import com.formation.spring_inicio_jpa_v1.entities.EventEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<EventEntity, Integer> {

    // select * from Event where title = :title
    Iterable<EventEntity> findByTitleOrderByIdDesc(String title);

    @Query("from EventEntity where description like %:keyword%")
    Iterable<EventEntity> findDescriptionByKeyword(@Param("keyword") String keyword);
    // same :
    //	Iterable<EventEntity> findByDescriptionContains(String keyword);
}
