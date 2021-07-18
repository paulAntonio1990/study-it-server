package com.degree.studyitserver.service;

import com.degree.studyitserver.domain.entity.*;
import com.degree.studyitserver.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final ChapterRepository chapterRepository;
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final TutoringSessionRepository tutoringSessionRepository;
    private final SessionMessageRepository sessionMessageRepository;


    @Autowired
    public CourseService(CourseRepository courseRepository,
                         ChapterRepository chapterRepository,
                         CommentRepository commentRepository,
                         PostRepository postRepository,
                         TutoringSessionRepository tutoringSessionRepository,
                         SessionMessageRepository sessionMessageRepository) {
        this.courseRepository = courseRepository;
        this.chapterRepository = chapterRepository;
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.tutoringSessionRepository = tutoringSessionRepository;
        this.sessionMessageRepository = sessionMessageRepository;
    }

    public Course create(Course newCourse, List<Chapter> chapters) {
        Course createdCourse = courseRepository.save(newCourse);
        Content content = createdCourse.getContent();

        chapters.forEach(chapter -> chapter.setContent(content));

        List<Chapter> savedChapters = chapterRepository.saveAll(chapters);

        return createdCourse;
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public void deleteById(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new IllegalArgumentException("Course ID not found!"));

        List<TutoringSession> tutoringSessions = course.getTutoringSessions();
        tutoringSessions.forEach(tutoringSession -> {
            sessionMessageRepository.deleteAll(tutoringSession.getSessionMessages());
            tutoringSession.setSessionMessages(new ArrayList<>());
        });
        tutoringSessionRepository.deleteAll(tutoringSessions);
        course.setTutoringSessions(new ArrayList<>());

        List<Chapter> chapters = course.getContent().getChapters();
        chapterRepository.deleteAll(chapters);
        course.getContent().setChapters(new ArrayList<>());

        List<Post> posts = course.getPosts();
        posts.forEach(post -> {
            commentRepository.deleteAll(post.getComments());
            post.setComments(new ArrayList<>());
        });
        postRepository.deleteAll(posts);
        course.setPosts(new ArrayList<>());

        courseRepository.deleteById(courseId);
    }

    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid course id!"));
    }

    public Course update(Course toEditCourse) {
        return courseRepository.save(toEditCourse);
    }
}
