package com.formation.startrestspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;
	
	@Autowired 
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping(value="", method = {RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT})
	public UserModel createUser(@RequestBody UserModel userModel) {
		
		return userService.save(userModel);
	}
	
	@GetMapping("")
	public Iterable<UserModel> findAll() {
		return userService.findAll();
		
	}
	
	@GetMapping("/{id}")
	public UserModel findById(@PathVariable Long id) {
		if (userService.findById(id).isPresent()) {
			return userService.findById(id).get();
		}
		return null;
	}

}
