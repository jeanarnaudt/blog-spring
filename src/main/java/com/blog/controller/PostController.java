package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blog")
public class PostController {

   @GetMapping("/posts/{slug}-{id}")
   public String getPost(ModelMap model, @PathVariable String slug, @PathVariable String id) {
      model.addAttribute("activePage", "blog");
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
