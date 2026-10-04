package com.blog.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String title;

   private String slug;

   private String content;

   private String description;

   private String author;

   private LocalDateTime createdAt;

   private LocalDateTime updatedAt;

   private LocalDateTime publishedAt;

   private boolean isPublished;

   public Post() {
      this.createdAt = LocalDateTime.now();
   }

   public Post(Long id, String title, String slug, String content, String description, String author, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime publishedAt, boolean isPublished) {
      this.id = id;
      this.title = title;
      this.slug = slug;
      this.content = content;
      this.description = description;
      this.author = author;
      this.createdAt = createdAt;
      this.updatedAt = updatedAt;
      this.publishedAt = publishedAt;
      this.isPublished = isPublished;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getSlug() {
      return slug;
   }

   public void setSlug(String slug) {
      this.slug = slug;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getAuthor() {
      return author;
   }

   public void setAuthor(String author) {
      this.author = author;
   }

   public LocalDateTime getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(LocalDateTime createdAt) {
      this.createdAt = createdAt;
   }

   public LocalDateTime getUpdatedAt() {
      return updatedAt;
   }

   public void setUpdatedAt(LocalDateTime updatedAt) {
      this.updatedAt = updatedAt;
   }

   public LocalDateTime getPublishedAt() {
      return publishedAt;
   }

   public void setPublishedAt(LocalDateTime publishedAt) {
      this.publishedAt = publishedAt;
   }

   public boolean isPublished() {
      return isPublished;
   }

   public void setPublished(boolean published) {
      isPublished = published;
   }

   @Override
   public String toString() {
      return "Post{" +
         "id=" + id +
         ", title='" + title + '\'' +
         ", slug='" + slug + '\'' +
         ", content='" + content + '\'' +
         ", description='" + description + '\'' +
         ", author='" + author + '\'' +
         ", createdAt=" + createdAt +
         ", updatedAt=" + updatedAt +
         ", publishedAt=" + publishedAt +
         ", isPublished=" + isPublished +
         '}';
   }
}
