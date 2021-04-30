package com.formation.springwebflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.springwebflix.entities.Category;
import com.formation.springwebflix.repositories.CategoryRepository;

@Service
public class CategoryService {

	private CategoryRepository categoryRepository;
	
	@Autowired 
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public Iterable<Category> findAll() {
		return categoryRepository.findAll();
	}
	
}

