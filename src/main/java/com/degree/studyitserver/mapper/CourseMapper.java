package com.degree.studyitserver.mapper;

import com.degree.studyitserver.domain.dto.CourseDto;
import com.degree.studyitserver.domain.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {TutoringSessionMapper.class, UserMapper.class})
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    @Mapping(source = "course.tutoringSessions", target = "tutoringSessionDtos")
    CourseDto toDto(Course course);

    Course toEntity(CourseDto courseDto);
    List<CourseDto> toDtos(List<Course> courses);
    List<Course> toEntities(List<CourseDto> courseDtos);

}
