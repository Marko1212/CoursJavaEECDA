package com.formation.springwebflix.controllers;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.formation.springwebflix.entities.User;
import com.formation.springwebflix.services.UserService;

@Controller
public class UserController {

	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/sign-up")
	public String getSignUp(Model model) {
		model.addAttribute("page", "user/sign-up");
		model.addAttribute("user", new User());
		return "index";
	}
	
	@PostMapping("/sign-up")
	public String postSignUp(Model model, @Valid @ModelAttribute(name = "user") User user, BindingResult userBinding) {
		
		if(!userBinding.hasErrors()) {
			if (user.getPassword().equals(user.getRepassword())) {
				// save dans la bdd après chiffrage du mdp
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(9);
				String p = passwordEncoder.encode(user.getPassword());
				user.setPassword(p);
				userService.save(user);
				return "redirect:/";
			}
			model.addAttribute("notSamePassword", "Les mots de passe ne sont pas identiques");
		}
		
		
		model.addAttribute("page", "user/sign-up");
		model.addAttribute("user", user);
		return "index";
	}

}
