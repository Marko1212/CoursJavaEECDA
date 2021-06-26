package com.formation.springwebflix.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.springwebflix.entities.User;
import com.formation.springwebflix.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public Optional<User> findByEmailOrUsername(String email) {
		return userRepository.findByEmailOrUsername(email, email);
	}
	
}
