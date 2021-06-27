package com.formation.springwebflix.controllers;



import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.formation.springwebflix.entities.User;
import com.formation.springwebflix.services.UserService;

@Controller
public class UserController {

	private final UserService userService;
	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
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
	
	@GetMapping("/sign-in")
	public String getSignIn(Model model) {
		model.addAttribute("page", "user/sign-in");
		return "index";
	}
	
	@PostMapping("/sign-in")
	public String postSignIn(Model model, 
			@RequestParam(name="email") String email,
			@RequestParam(name="password") String password,
			HttpServletRequest request
			) {
		if (!email.isEmpty() && !password.isEmpty()) {
			Optional<User> userOp = userService.findByEmailOrUsername(email);
			if (userOp.isPresent()) {
				User user = userOp.get();
				if (passwordEncoder.matches(password, user.getPassword())) {
					request.getSession().setAttribute("userEmail", user.getEmail());
					request.getSession().setAttribute("userUsername", user.getUsername());
					// j'ouvre ma session
					return "redirect:/";
				}
			}
			
		}
		model.addAttribute("error", "Email et/ou pseudo et/ou mot de passe incorrects");
		model.addAttribute("page", "user/sign-in");
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
	

}
