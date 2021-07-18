package com.degree.studyitserver.mapper;

import com.degree.studyitserver.domain.dto.ChapterDto;
import com.degree.studyitserver.domain.entity.Chapter;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ChapterMapper {
    ChapterMapper INSTANCE = Mappers.getMapper(ChapterMapper.class);

    ChapterDto toDto(Chapter chapter);
    Chapter toEntity(ChapterDto chapterDto);
    List<ChapterDto> toDtos(List<Chapter> chapters);
    List<Chapter> toEntities(List<ChapterDto> chapterDtos);
}
