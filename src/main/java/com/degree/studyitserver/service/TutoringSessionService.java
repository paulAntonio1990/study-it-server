package com.degree.studyitserver.service;

import com.degree.studyitserver.domain.entity.Course;
import com.degree.studyitserver.domain.entity.TutoringSession;
import com.degree.studyitserver.repository.CourseRepository;
import com.degree.studyitserver.repository.TutoringSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutoringSessionService {

    private final TutoringSessionRepository tutoringSessionRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public TutoringSessionService(TutoringSessionRepository tutoringSessionRepository, CourseRepository courseRepository) {
        this.tutoringSessionRepository = tutoringSessionRepository;
        this.courseRepository = courseRepository;
    }

    public TutoringSession create(Long courseId, TutoringSession tutoringSession) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new IllegalArgumentException("Invalid course ID!"));
        tutoringSession.setCourse(course);
        return tutoringSessionRepository.save(tutoringSession);
    }

    public List<TutoringSession> findAllByCourseId(Long courseId) {
        return tutoringSessionRepository.findAllByCourse_Id(courseId);
    }

    public void deleteById(Long id) {
        TutoringSession session = tutoringSessionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid tutoring session ID!"));

        tutoringSessionRepository.delete(session);
    }
}
