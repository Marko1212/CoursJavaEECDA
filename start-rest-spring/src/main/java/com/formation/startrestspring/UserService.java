package com.formation.startrestspring;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Iterable<UserModel> findAll() {
		return userRepository.findAll();
	}
	
	public Optional<UserModel> findById(long id) {
		return userRepository.findById(id);
	}
	
	public UserModel save(UserModel userModel) {
		return userRepository.save(userModel);
	}

	public void delete(UserModel userModel) {
		userRepository.delete(userModel);
	}
}
