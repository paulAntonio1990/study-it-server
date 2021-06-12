package com.degree.studyitserver.controller;

import com.degree.studyitserver.domain.dto.CourseDto;
import com.degree.studyitserver.mapper.CourseMapper;
import com.degree.studyitserver.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/course")
public class CourseController {

    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @Autowired
    public CourseController(CourseService courseService,
                            CourseMapper courseMapper) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;
    }

    @PostMapping(path = "/add-course")
    public CourseDto addCourse(@RequestBody CourseDto newCourse) {
        return courseMapper.toDto(
                courseService.create(courseMapper.toEntity(newCourse)));
    }

    @GetMapping(path = "find-all")
    private List<CourseDto> findAllCourses() {
        return courseMapper.toDtos(courseService.findAll());
    }
}