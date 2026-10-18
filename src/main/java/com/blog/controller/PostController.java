package com.blog.controller;

import com.blog.model.dto.PostDto;
import com.blog.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blog")
public class PostController {
   
   private final PostService postService;

   public PostController(PostService postService) {
      this.postService = postService;
   }

   @GetMapping("/posts/{slug}")
   public String getPost(ModelMap model, @PathVariable String slug) {
      PostDto postDto = postService.findBySlug(slug);
      model.addAttribute("activePage", "blog");
      model.addAttribute("post", postDto);
      return "posts/single";
   }

   @PostMapping("/posts")
   public String createPost() {
      return "posts/create";
   }

   @PutMapping("/posts/{slug}-{id}/edit")
   public String updatePost(@PathVariable String slug, @PathVariable String id) {
      System.out.println(slug + id);
      return "posts/update";
   }

}
