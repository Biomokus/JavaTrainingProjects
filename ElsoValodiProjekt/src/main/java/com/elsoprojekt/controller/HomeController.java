package com.elsoprojekt.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elsoprojekt.domain.Story;
import com.elsoprojekt.repository.StoryRepository;
import com.elsoprojekt.service.StoryService;

@Controller
public class HomeController {
	
	private StoryService storyService;
	
	@Autowired
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}

	@RequestMapping("/")
	public String stories(Model model) {
		model.addAttribute("pageTitle", "Gondolatok a világból");
		model.addAttribute("stories", storyService.getStories());
		return "stories";
	}
	
	@RequestMapping("/story")
	public String story(Model model) {
		model.addAttribute("pageTitle", "Gondolatok a világból");
		model.addAttribute("story", storyService.getStory());
		return "story";
	}
	
	@RequestMapping("/title/{title}")
	public String searchForTitle(@PathVariable(value = "title") String title, Model model) {
		model.addAttribute("story", storyService.getSpecificStory(title));
		return "story";	
	}
	
//	private List<Story> getStories() {
//		
//		List<Story> stories = storyRepo.findAll();
//		return stories;
		
//		ArrayList<Story> stories = new ArrayList<>();
		
//		Story story1 = new Story();
//		story1.setTitle("Első történet");
//		story1.setPosted(new Date());
//		story1.setAuthor("Gábor");
//		story1.setContent("<p>Ez már éles adat, amivel dolgozom.</p>");
//		
//		Story story2 = new Story();
//		story2.setTitle("Második történet");
//		story2.setPosted(new Date());
//		story2.setAuthor("Marci");
//		story2.setContent("<p>Egyszer volt, hol nem volt.</p>");
//		
//		stories.add(story1);
//		stories.add(story2);
		

//	}

}
