package com.formation.springwebflix.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.formation.springwebflix.entities.User;

@Controller
public class UserController {
	
	@GetMapping("/sign-up")
	public String getSignUp(Model model) {
		model.addAttribute("page", "user/sign-up");
		model.addAttribute("user", new User());
		return "index";
	}

}
