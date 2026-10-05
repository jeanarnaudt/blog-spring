package com.blog.config;

import com.blog.model.dto.PostSeed;
import com.blog.model.entity.Post;
import com.blog.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import tools.jackson.databind.json.JsonMapper;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {
	private final PostRepository postRepo;
	private final JsonMapper jsonMapper;

	DataSeeder(PostRepository postRepo, JsonMapper jsonMapper) {
		this.postRepo = postRepo;
		this.jsonMapper = jsonMapper;
	}

	@Override
	public void run(String... args) throws Exception {
		if (postRepo.count() > 0) {
			return;
		}

		PostSeed[] seeds;
		try (InputStream in = new ClassPathResource("data/posts.json").getInputStream()) {
			seeds = jsonMapper.readValue(in, PostSeed[].class);
		}

		List<Post> posts = Arrays.stream(seeds)
			.map(seed -> {
				Post post = new Post();
				post.setTitle(seed.title());
				post.setSlug(seed.slug());
				post.setDescription(seed.description());
				post.setContent(seed.content());
				post.setPublishedAt(LocalDateTime.ofInstant(seed.publishedAt(), ZoneOffset.UTC));
				post.setPublished(true);
				return post;
			})
			.toList();

		postRepo.saveAll(posts);
	}
}
