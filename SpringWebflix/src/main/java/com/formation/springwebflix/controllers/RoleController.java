package com.formation.springwebflix.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleController {
	
	@GetMapping("/admin/test-role")
	public String testRole(Model model) {
		model.addAttribute("page", "test-role");
		return "index";
	}
	
	
}
