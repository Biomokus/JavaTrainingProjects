package com.elsoprojekt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elsoprojekt.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
	
	List<Author> findAll();
 
}
