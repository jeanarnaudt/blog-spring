package com.blog.service;

import com.blog.model.dto.PostDto;

import java.util.List;

public interface PostService {

	List<PostDto> findAll();
	
	List<PostDto> findLatest();
	
	PostDto findBySlug(String slug);

}

