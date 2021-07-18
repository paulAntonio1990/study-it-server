package com.degree.studyitserver.mapper;

import com.degree.studyitserver.domain.dto.ContentDto;
import com.degree.studyitserver.domain.entity.Content;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {ChapterMapper.class})
public interface ContentMapper {
    ContentMapper INSTANCE = Mappers.getMapper(ContentMapper.class);

    ContentDto toDto(Content content);
    Content toEntity(ContentDto contentDto);
    List<ContentDto> toDtos(List<Content> contents);
    List<Content> toEntities(List<ContentDto> contentDtos);
}
