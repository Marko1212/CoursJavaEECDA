package com.formation.springwebflix.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.springwebflix.entities.Movie;
import com.formation.springwebflix.repositories.MovieRepository;

@Service
public class MovieService {

	private final MovieRepository movieRepository;
	
	@Autowired
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	public Iterable <Movie> findAll() {
		return movieRepository.findAll();
	}
	
	public Optional<Movie> findById(Integer id) {
		return movieRepository.findById(id);
	}
	
	public Movie save(Movie movie) {
		return movieRepository.save(movie);
	}
	
	public boolean delete(Movie movie) {
		movieRepository.delete(movie);
		return !movieRepository.existsById(movie.getId());
	}
	
	
}
