package com.formation.springwebflix.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formation.springwebflix.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
