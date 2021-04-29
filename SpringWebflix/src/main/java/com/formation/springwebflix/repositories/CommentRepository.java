package com.formation.springwebflix.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formation.springwebflix.entities.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer>{

}
