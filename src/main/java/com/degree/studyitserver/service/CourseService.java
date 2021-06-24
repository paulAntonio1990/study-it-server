package com.degree.studyitserver.service;

import com.degree.studyitserver.domain.dto.CourseDto;
import com.degree.studyitserver.domain.entity.Course;
import com.degree.studyitserver.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course create(Course newCourse) {
        return courseRepository.save(newCourse);
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public void deleteById(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid course id!"));
    }

    public Course update(Course toEditCourse) {
        return courseRepository.save(toEditCourse);
    }
}
