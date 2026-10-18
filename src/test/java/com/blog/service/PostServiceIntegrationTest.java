package com.blog.service;

import com.blog.mapper.PostMapper;
import com.blog.model.dto.PostDto;
import com.blog.model.entity.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceIntegrationTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostMapper postMapper;

    @Test
    void testPostMapperAndServiceInjected() {
        assertNotNull(postService, "PostService should be injected");
        assertNotNull(postMapper, "PostMapper bean should be generated and injected");

        Post post = new Post();
        post.setId(1L);
        post.setTitle("Test Title");
        post.setSlug("test-title");
        post.setContent("Test Content");
        post.setDescription("Test Description");
        post.setPublishedAt(LocalDateTime.now());

        PostDto dto = postMapper.toDto(post);
        assertNotNull(dto);
        assertEquals(post.getId(), dto.getId());
        assertEquals(post.getTitle(), dto.getTitle());
        assertEquals(post.getSlug(), dto.getSlug());
        assertEquals(post.getContent(), dto.getContent());
        assertEquals(post.getDescription(), dto.getDescription());
        assertEquals(post.getPublishedAt(), dto.getPublishedAt());
    }
}
