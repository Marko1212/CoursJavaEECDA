package com.formation.springwebflix.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formation.springwebflix.entities.Actor;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Integer>{

}
