package com.formation.springwebflix.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formation.springwebflix.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	Optional<User> findByEmailOrUsername(String email, String username);
}
