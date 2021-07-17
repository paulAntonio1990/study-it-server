package com.degree.studyitserver.service;

import com.degree.studyitserver.domain.entity.Comment;
import com.degree.studyitserver.domain.entity.Post;
import com.degree.studyitserver.repository.CommentRepository;
import com.degree.studyitserver.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public Comment create(Long postId, Comment comment) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("Invalid post ID!"));
        comment.setPost(post);
        comment.setDate(new Date());
        return commentRepository.save(comment);
    }

    public void deleteById(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid comment ID!"));
        commentRepository.delete(comment);
    }
}
