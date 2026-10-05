package com.blog.model.dto;

import java.time.Instant;

public record PostSeed(String title, String slug, Instant publishedAt, String description, String content) {
}
