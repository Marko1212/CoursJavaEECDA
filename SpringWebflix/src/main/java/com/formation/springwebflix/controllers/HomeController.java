package com.formation.springwebflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.formation.springwebflix.services.MovieService;

@Controller
public class HomeController {

	private final MovieService movieService;
	
	@Autowired
	public HomeController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("page", "home");
		model.addAttribute("movies", movieService.findAll());
		return "index";
	}
	
}
