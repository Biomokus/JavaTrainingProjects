package com.elsoprojekt.service;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elsoprojekt.domain.Author;
import com.elsoprojekt.domain.Story;
import com.elsoprojekt.repository.AuthorRepository;
import com.elsoprojekt.repository.StoryRepository;

@Service
public class StoryService {
	
	private StoryRepository storyRepo;
	private AuthorRepository authorRepo;

	@Autowired
	public void setStoryRepo(StoryRepository storyRepo) {
		this.storyRepo = storyRepo;
	}
	
	@Autowired
	public void setAuthorRepo(AuthorRepository authorRepo) {
		this.authorRepo = authorRepo;
		
	}	

	public List<Story> getStories() {
		return storyRepo.findAll();
	}
	
	public Story getStory() {
		return storyRepo.findFirstByOrderByPostedDesc();
	}

	public Story getSpecificStory(String title) {
		return storyRepo.findByTitle(title);
	}

	
//	alternative way to story-injection:
	
//	@PostConstruct
//	public void init() {
//		Author author = new Author("BelsőLevente", 2);
//		authorRepo.save(author);
//		
//		Story story = new Story("Belső cím", "Belső tartalom", new Date(), author);
//		storyRepo.save(story);
//	}

}
