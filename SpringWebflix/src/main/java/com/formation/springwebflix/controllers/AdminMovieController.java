package com.formation.springwebflix.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.formation.springwebflix.entities.Category;
import com.formation.springwebflix.entities.Movie;
import com.formation.springwebflix.services.CategoryService;
import com.formation.springwebflix.services.FileService;
import com.formation.springwebflix.services.MovieService;

@Controller
@RequestMapping("/admin/movie")
public class AdminMovieController {
	
	private final FileService fileService;
	private final MovieService movieService;
	private final CategoryService categoryService;
	
	@Autowired
	public AdminMovieController(FileService fileService, MovieService movieService, CategoryService categoryService) {
		this.fileService = fileService;
		this.movieService = movieService;
		this.categoryService = categoryService;
	
	}
	
	@GetMapping("")
	public String getAddMovie(Model model) {
		model.addAttribute("page", "movie/add");
		model.addAttribute("movie", new Movie());
		model.addAttribute("category", categoryService.findAll());
		return "index";
	}
	
	@PostMapping("")
	public String postAddMovie(Model model, @Validated @ModelAttribute(name="movie") Movie movie, 
			BindingResult movieBindingResult,
			@RequestParam(name="file") MultipartFile file)
	{
		System.out.println(file.isEmpty());
		if (!movieBindingResult.hasErrors() && !file.isEmpty()) {
			movie.setCover(fileService.createFileName(file));
			
			movie.setCategory(new Category(4, "Science-fiction"));
			movieService.save(movie);
			if (movie.getId() != null) {
				fileService.uploadfile(file, movie.getCover());
			}
			System.out.println(movie);
			return "redirect:/";
		}
		model.addAttribute("page", "movie/add");
		if (file.isEmpty()) {
		model.addAttribute("fileError", "movie.add.form.file.empty.message");
		}
		System.out.println(movieBindingResult.getAllErrors());
		return "index";
	}

}
