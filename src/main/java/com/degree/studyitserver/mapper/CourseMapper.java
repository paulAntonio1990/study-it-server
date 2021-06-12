package com.degree.studyitserver.mapper;

import com.degree.studyitserver.domain.dto.CourseDto;
import com.degree.studyitserver.domain.entity.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDto toDto(Course course);
    Course toEntity(CourseDto courseDto);
    List<CourseDto> toDtos(List<Course> courses);
    List<Course> toEntities(List<CourseDto> courseDtos);

}
