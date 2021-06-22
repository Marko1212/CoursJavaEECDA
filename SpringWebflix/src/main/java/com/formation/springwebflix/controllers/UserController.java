package com.formation.springwebflix.controllers;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.formation.springwebflix.entities.User;

@Controller
public class UserController {
	
	@GetMapping("/sign-up")
	public String getSignUp(Model model) {
		model.addAttribute("page", "user/sign-up");
		model.addAttribute("user", new User());
		return "index";
	}
	
	@PostMapping("/sign-up")
	public String postSignUp(Model model, @Valid @ModelAttribute(name = "user") User user, BindingResult userBinding) {
		return "index";
	}

}
