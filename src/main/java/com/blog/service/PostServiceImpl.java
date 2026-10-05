package com.blog.service;

import com.blog.mapper.PostMapper;
import com.blog.model.dto.PostDto;
import com.blog.model.entity.Post;
import com.blog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
	private final PostRepository postRepo;
	private final PostMapper postMapper;
	
	public PostServiceImpl(PostRepository postRepo, PostMapper postMapper) {
		this.postRepo = postRepo;
		this.postMapper = postMapper;
	}
	
	@Override
	public List<PostDto> findAll() {
		List<Post> posts = postRepo.findAllByOrderByPublishedAtDesc();
		return posts.stream().map(postMapper::toDto).toList();
	}
	
	@Override
	public List<PostDto> findLatest() {
		List<Post> latestPosts = postRepo.findTop5ByOrderByPublishedAtDesc();
		return latestPosts.stream().map(postMapper::toDto).toList();
	}
}
