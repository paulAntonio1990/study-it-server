package com.degree.studyitserver.controller;

import com.degree.studyitserver.domain.dto.CourseDto;
import com.degree.studyitserver.mapper.CourseMapper;
import com.degree.studyitserver.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/courses")
public class CourseController {

    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @Autowired
    public CourseController(CourseService courseService,
                            CourseMapper courseMapper) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;
    }

    @PostMapping()
    @PreAuthorize("hasRole('PROFESOR') or hasRole('ADMIN')")
    public CourseDto addCourse(@RequestBody CourseDto newCourse) {
        return courseMapper.toDto(
                courseService.create(courseMapper.toEntity(newCourse)));
    }

    @GetMapping("/find-all")
    @PreAuthorize("hasRole('STUDENT') or hasRole('PROFESOR') or hasRole('ADMIN')")
    public List<CourseDto> findAllCourses() {

        return courseMapper.toDtos(courseService.findAll());
    }

    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasRole('PROFESOR') or hasRole('ADMIN')")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteById(id);
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasRole('STUDENT') or hasRole('PROFESOR') or hasRole('ADMIN')")
    public CourseDto findById(@PathVariable Long id) {
        return courseMapper.toDto(courseService.findById(id));
    }

    @PutMapping(path = "/{id}")
    @PreAuthorize("hasRole('PROFESOR') or hasRole('ADMIN')")
    public CourseDto editCourse(@RequestBody CourseDto newCourse) {
        return courseMapper.toDto(
                courseService.update(courseMapper.toEntity(newCourse)));
    }
}
