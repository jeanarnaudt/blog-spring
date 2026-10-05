package com.blog.mapper;

import com.blog.model.dto.PostDto;
import com.blog.model.entity.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
	PostDto toDto(Post post);
}
