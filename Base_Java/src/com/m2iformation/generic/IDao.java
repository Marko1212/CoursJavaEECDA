package com.m2iformation.generic;

import java.util.List;

public interface IDao<T> {
	void insert(T objet);
	T findById(int id);
	void update(int id, T objet);
	void delete(int id);
	List<T> findall();
	// void delete(T objet);

}

