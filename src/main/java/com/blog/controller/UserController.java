package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class UserController {

   @GetMapping("/users")
   public String index() {
      return "users/index";
   }

   @GetMapping("/users/{id}")
   public String getUser(@PathVariable String id) {
      return "posts/single";
   }

   @GetMapping("/users/add")
   public String createUser() {
      return "posts/create";
   }

   @PutMapping("/users/{id}/edit")
   public String updateUser(@PathVariable String id) {
      return "users/update";
   }
}
