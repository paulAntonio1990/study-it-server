package com.degree.studyitserver.mapper;


import com.degree.studyitserver.domain.dto.CommentDto;
import com.degree.studyitserver.domain.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {UserMapper.class})
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentDto toDto(Comment comment);
    Comment toEntity(CommentDto commentDto);
    List<CommentDto> toDtos(List<Comment> comments);
    List<Comment> toEntities(List<CommentDto> commentDtos);

}
