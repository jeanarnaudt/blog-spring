package com.blog.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class PostDto implements Serializable {
	Long id;
	String title;
	String slug;
	String content;
	String description;
	LocalDateTime publishedAt;
}