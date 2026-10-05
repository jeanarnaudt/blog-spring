package com.blog.controller;

import com.blog.model.dto.PostDto;
import com.blog.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BlogController {
	private final PostService postService;
	
	public BlogController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping("/")
	public String index(ModelMap modelMap) {
		List<PostDto> latestPosts = postService.findLatest();
		modelMap.addAttribute("latestPosts", latestPosts);
		modelMap.addAttribute("activePage", "home");
		return "index";
	}
	
	@GetMapping("/blog")
	public String blog(ModelMap modelMap) {
		List<PostDto> posts = postService.findAll();
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
