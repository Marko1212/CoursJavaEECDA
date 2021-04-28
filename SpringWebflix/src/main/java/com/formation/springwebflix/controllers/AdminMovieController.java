package com.formation.springwebflix.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formation.springwebflix.entities.MovieEntity;

@Controller
@RequestMapping("/admin/movie")
public class AdminMovieController {
	
	@GetMapping("")
	public String getAddMovie(Model model) {
		model.addAttribute("page", "movie/add");
		model.addAttribute("movie", new MovieEntity());
		return "index";
	}
	
	@PostMapping("")
	public String postAddMovie(Model model, @Validated @ModelAttribute(name="movie") MovieEntity movie, 
			BindingResult movieBindingResult) 
	{
		
		if (!movieBindingResult.hasErrors()) {
			// TODO sauvegarde en BDD
			System.out.println(movie);
			return "redirect:/";
		}
		model.addAttribute("page", "movie/add");
		System.out.println(movieBindingResult.getAllErrors());
		return "index";
	}

}
