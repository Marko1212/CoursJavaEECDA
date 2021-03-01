package com.m2iformation.jdbcVilles.repositories;

import java.util.List;

import com.m2iformation.jdbcVilles.models.Ville;

public interface VilleRepository extends IRepository<Integer, Ville> {
	
	List<Ville> searchByName(String name);

}
