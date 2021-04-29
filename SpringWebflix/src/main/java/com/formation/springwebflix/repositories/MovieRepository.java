package com.formation.springwebflix.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formation.springwebflix.entities.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
	
		Iterable<Movie> findAllByTitleLikeAndDurationBetween(String title, Integer min, Integer max);
		
	
}
