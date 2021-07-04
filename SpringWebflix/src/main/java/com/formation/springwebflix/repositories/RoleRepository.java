package com.formation.springwebflix.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formation.springwebflix.entities.Role;
import com.formation.springwebflix.enums.RoleEnum;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{

	Role findByCode(RoleEnum role);

}
