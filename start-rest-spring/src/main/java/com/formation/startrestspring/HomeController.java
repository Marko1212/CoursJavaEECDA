package com.formation.startrestspring;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "Hello World";
	}
	
	@GetMapping("/get-user")
	public UserModel getUser() {
		return new UserModel(
				1L, "marko", "askovic", "marko@test.fr"
				);
	}
	
	@GetMapping("/get-users")
	public List<UserModel> getUsers() {
		return Arrays.asList(
				new UserModel(1L, "marko", "askovic", "marko@test.fr"),
				new UserModel(2L, "samuel", "michaux", "samuel@test.fr"),
				new UserModel(3L, "matthieu", "mota", "matthieu@test.fr"),
				new UserModel(4L, "geoffrey", "geoffrey", "geoffrey@test.fr"),
				new UserModel(5L, "marjolaine", "marjolaine", "marjolaine@test.fr"),
				new UserModel(6L, "julien", "julien", "julien@test.fr")
			);
	}

}


