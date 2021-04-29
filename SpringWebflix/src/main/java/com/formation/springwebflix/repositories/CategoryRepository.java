package com.formation.springwebflix.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formation.springwebflix.entities.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{

}

