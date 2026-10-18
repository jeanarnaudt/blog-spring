package com.blog.service;

import com.blog.exception.ResourceNotFoundException;
import com.blog.mapper.PostMapper;
import com.blog.model.dto.PostDto;
import com.blog.model.entity.Post;
import com.blog.repository.PostRepository;
import com.blog.util.MarkdownRenderer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
	private final PostRepository postRepo;
	private final PostMapper postMapper;
	private final MarkdownRenderer markdownRenderer;
	
	public PostServiceImpl(PostRepository postRepo, PostMapper postMapper, MarkdownRenderer markdownRenderer) {
		this.postRepo = postRepo;
		this.postMapper = postMapper;
		this.markdownRenderer = markdownRenderer;
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
	
	@Override
	public PostDto findBySlug(String slug) {
		Post post = postRepo.findBySlug(slug).orElseThrow(
			() -> new ResourceNotFoundException("Post not found with slug: " + slug)
		);
		PostDto dto = postMapper.toDto(post);
		dto.setContent(markdownRenderer.toHtml(dto.getContent()));
		return dto;
	}
}
