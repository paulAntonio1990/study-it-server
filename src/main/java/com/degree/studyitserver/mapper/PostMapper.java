package com.degree.studyitserver.mapper;

import com.degree.studyitserver.domain.dto.PostDto;
import com.degree.studyitserver.domain.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {UserMapper.class})
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostDto toDto(Post post);
    Post toEntity(PostDto postDto);
    List<PostDto> toDtos(List<Post> posts);
    List<Post> toEntities(List<PostDto> postDtos);
}
