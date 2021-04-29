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

import com.formation.springwebflix.entities.MovieEntity;
import com.formation.springwebflix.services.FileService;

@Controller
@RequestMapping("/admin/movie")
public class AdminMovieController {
	
	private final FileService fileService;
	
	@Autowired
	public AdminMovieController(FileService fileService) {
		this.fileService = fileService;
	}
	
	@GetMapping("")
	public String getAddMovie(Model model) {
		model.addAttribute("page", "movie/add");
		MovieEntity mov = new MovieEntity();
		mov.setTitle("coucou");
		mov.setDescription("coucou");
		mov.setDuration(20);
		mov.setReleaseDate(new Date());
		model.addAttribute("movie", mov);
		return "index";
	}
	
	@PostMapping("")
	public String postAddMovie(Model model, @Validated @ModelAttribute(name="movie") MovieEntity movie, 
			BindingResult movieBindingResult,
			@RequestParam(name="file") MultipartFile file)
	{
		System.out.println(file.isEmpty());
		if (!movieBindingResult.hasErrors() && !file.isEmpty()) {
			// TODO sauvegarde en BDD
			
			movie.setCover(fileService.uploadfile(file));
			
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
