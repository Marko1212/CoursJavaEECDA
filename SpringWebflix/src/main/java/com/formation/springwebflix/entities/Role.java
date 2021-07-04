package com.formation.springwebflix.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.formation.springwebflix.enums.RoleEnum;

import lombok.Data;

@Data
@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private RoleEnum code;
	
	@OneToMany(mappedBy = "role")
	private List<User> users;
	
	
	
	
	
	
	
	
	
}
