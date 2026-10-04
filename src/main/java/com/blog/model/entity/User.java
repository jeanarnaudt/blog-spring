package com.blog.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String username;

   private String email;

   private String password;

   private String role;

   private boolean enabled;

   private LocalDateTime createdAt;

   private LocalDateTime updatedAt;

   public User() {
      this.createdAt = LocalDateTime.now();
   }

   public User(Long id, String username, String email, String password, String role, boolean enabled, LocalDateTime createdAt) {
      this.id = id;
      this.username = username;
      this.email = email;
      this.password = password;
      this.role = role;
      this.enabled = enabled;
      this.createdAt = createdAt;
   }

   public LocalDateTime getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(LocalDateTime createdAt) {
      this.createdAt = createdAt;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getRole() {
      return role;
   }

   public void setRole(String role) {
      this.role = role;
   }

   public boolean isEnabled() {
      return enabled;
   }

   public void setEnabled(boolean enabled) {
      this.enabled = enabled;
   }

   public LocalDateTime getUpdatedAt() {
      return updatedAt;
   }

   public void setUpdatedAt(LocalDateTime updatedAt) {
      this.updatedAt = updatedAt;
   }

   @Override
   public String toString() {
      return "User{" +
         "id=" + id +
         ", username='" + username + '\'' +
         ", email='" + email + '\'' +
         ", password='" + password + '\'' +
         ", role='" + role + '\'' +
         ", enabled=" + enabled +
         ", createdAt=" + createdAt +
         ", updatedAt=" + updatedAt +
         '}';
   }
}
