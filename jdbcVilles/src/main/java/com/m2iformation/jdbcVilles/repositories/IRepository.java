package com.m2iformation.jdbcVilles.repositories;

import java.util.List;

public interface IRepository<ID, MODEL> {
	//CRUD
int create(MODEL model);

MODEL findById(ID id);

List<MODEL> findAll();

int update(ID id, MODEL model);

int delete(ID id);
	
}
