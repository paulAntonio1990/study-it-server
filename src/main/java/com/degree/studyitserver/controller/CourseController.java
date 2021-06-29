package com.degree.studyitserver.controller;

import com.degree.studyitserver.domain.dto.CourseDto;
import com.degree.studyitserver.domain.entity.Course;
import com.degree.studyitserver.domain.entity.User;
import com.degree.studyitserver.mapper.CourseMapper;
import com.degree.studyitserver.repository.UserRepository;
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
    private final UserRepository userRepository;

    @Autowired
    public CourseController(CourseService courseService,
                            CourseMapper courseMapper,
                            UserRepository userRepository) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;
        this.userRepository = userRepository;
    }

    @PostMapping()
    @PreAuthorize("hasRole('PROFESOR') or hasRole('ADMIN')")
    public CourseDto addCourse(@RequestBody CourseDto newCourse) {
        User user = userRepository.findById(newCourse.getCreator().getId())
                .orElseThrow(() -> new IllegalArgumentException("User Id not found!"));

        Course course = courseMapper.toEntity(newCourse);
        course.setCreator(user);

        return courseMapper.toDto(courseService.create(course));
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
