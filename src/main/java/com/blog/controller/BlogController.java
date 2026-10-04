package com.blog.controller;

import com.blog.model.dto.PostPreview;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BlogController {
    private final List<PostPreview> posts = List.of(
        new PostPreview("Balancing Hobbies and Coding: How Hiking and Rock Climbing Help Me Stay Motivated", "balancing-hobbies-and-coding", LocalDate.of(2025, 2, 18), "Thoughts on maintaining energy and focus through outdoor activities and exercise."),
        new PostPreview("Reading for Inspiration: 5 Books That Shaped My Coding Journey", "5-books-that-shaped-my-coding-journey", LocalDate.of(2025, 2, 15), "A few of my favorite books, both fiction and non-fiction, that keep me motivated."),
        new PostPreview("Overcoming Imposter Syndrome as a New Developer", "overcoming-imposter-syndrome", LocalDate.of(2025, 2, 10), "Tips and personal reflections on dealing with self-doubt when learning to code."),
        new PostPreview("Exploring the World of Responsive Design", "exploring-responsive-design", LocalDate.of(2025, 2, 4), "The importance of making websites look great on different devices."),
        new PostPreview("My Favorite Dev Tools for Productivity", "dev-tools-for-productivity", LocalDate.of(2025, 1, 29), "A quick look at the tools I rely on, from code editors to browser extensions."),
        new PostPreview("Understanding JavaScript Basics", "understanding-javascript-basics", LocalDate.of(2025, 1, 28), "My adventure into JavaScript's fundamentals—variables, functions, loops, and more."),
        new PostPreview("Learning HTML & CSS: My First Week", "learning-html-css", LocalDate.of(2025, 1, 16), "A recap of my first steps in web development, from basic tags to styling techniques."),
        new PostPreview("Why I Chose Front-End Web Development", "why-i-chose-front-end-web-development", LocalDate.of(2025, 1, 12), "The reasons behind my shift to front-end and why this path excites me.")
    );
	
	@GetMapping("/")
	public String index(ModelMap modelMap) {
		List<PostPreview> latestPosts = posts.stream().limit(5).toList();
		modelMap.addAttribute("latestPosts", latestPosts);
		modelMap.addAttribute("activePage", "home");
		return "index";
	}
	
	@GetMapping("/blog")
	public String blog(ModelMap modelMap) {
		modelMap.addAttribute("posts", posts);
		modelMap.addAttribute("activePage", "blog");
		return "posts/index";
	}
	
	@GetMapping("/about")
	public String about(ModelMap modelMap) {
		modelMap.addAttribute("activePage", "about");
		return "about";
	}
	
	@GetMapping("/newsletter")
	public String newsletter(ModelMap modelMap) {
		modelMap.addAttribute("activePage", "newsletter");
		return "newsletter";
	}
	
}
