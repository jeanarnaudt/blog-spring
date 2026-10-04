package com.blog.model.dto;

import java.time.LocalDate;

public record PostPreview(String title, String slug, LocalDate publishedAt, String description) {
}
