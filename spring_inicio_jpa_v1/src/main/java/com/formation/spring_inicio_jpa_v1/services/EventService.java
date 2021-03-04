package com.formation.spring_inicio_jpa_v1.services;

import com.formation.spring_inicio_jpa_v1.entities.EventEntity;
import com.formation.spring_inicio_jpa_v1.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Iterable<EventEntity> findAll(){
        return eventRepository.findAll();
    }

    public Optional<EventEntity> findById(Integer id){
        return eventRepository.findById(id);
    }

    public EventEntity save(EventEntity e){
        return eventRepository.save(e);
    }

    public void delete(EventEntity e){
        eventRepository.delete(e);
    }

    public Iterable<EventEntity> findTitle(String title){
        return eventRepository.findByTitleOrderByIdDesc(title);
    }

    public Iterable<EventEntity> findDescriptionByKeyword(String keyword){
        return eventRepository.findDescriptionByKeyword(keyword);
    }


}
