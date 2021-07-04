package com.formation.springwebflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.springwebflix.entities.Role;
import com.formation.springwebflix.enums.RoleEnum;
import com.formation.springwebflix.repositories.RoleRepository;
import com.formation.springwebflix.repositories.UserRepository;

@Service
public class RoleService {
	
	private final RoleRepository roleRepository;
	
	@Autowired 
	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	public Role findByRole(RoleEnum role) {
		return roleRepository.findByCode(role);
	}
}
