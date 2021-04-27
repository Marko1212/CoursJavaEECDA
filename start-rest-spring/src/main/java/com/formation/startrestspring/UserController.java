package com.formation.startrestspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;
	
	@Autowired 
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@PostMapping("")
	public UserModel createUser(@RequestBody UserModel userModel) {
		
		return userService.save(userModel);
	}

}
