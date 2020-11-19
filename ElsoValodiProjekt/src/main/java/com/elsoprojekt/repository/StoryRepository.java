package com.elsoprojekt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elsoprojekt.domain.Story;

public interface StoryRepository extends CrudRepository<Story, Long> {
	
	//SELECT * FROM STORIES
	List<Story> findAll();
	
	//SELECT * FROM STORIES WHERE posted IN (SELECT max(posted) FROM stories) LIMIT 1
	Story findFirstByOrderByPostedDesc();

	Story findByTitle(String title);
 
}
