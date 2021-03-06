package com.degree.studyitserver.service;

import com.degree.studyitserver.domain.entity.Course;
import com.degree.studyitserver.domain.entity.Post;
import com.degree.studyitserver.repository.CommentRepository;
import com.degree.studyitserver.repository.CourseRepository;
import com.degree.studyitserver.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final CourseRepository courseRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public PostService(PostRepository postRepository, CourseRepository courseRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.courseRepository = courseRepository;
        this.commentRepository = commentRepository;
    }

    public Post create(Long courseId, Post post) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new IllegalArgumentException("Invalid course ID!"));
        post.setCourse(course);
        post.setDate(new Date());
        return postRepository.save(post);
    }

    public List<Post> findAllByCourseId(Long courseId) {
        return postRepository.findAllByCourse_Id(courseId);
    }

    public void deleteById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post ID!"));

        commentRepository.deleteAll(post.getComments());
        post.setComments(new ArrayList<>());

        postRepository.delete(post);
    }
}
