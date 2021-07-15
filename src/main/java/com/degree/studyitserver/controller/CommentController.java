package com.degree.studyitserver.controller;

import com.degree.studyitserver.domain.dto.CommentDto;
import com.degree.studyitserver.domain.entity.Comment;
import com.degree.studyitserver.mapper.CommentMapper;
import com.degree.studyitserver.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/comments")
public class CommentController {

    private final CommentService commentService;
    private final CommentMapper commentMapper;

    @Autowired
    public CommentController(CommentService commentService, CommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }

    @PostMapping("/{postId}/create")
    @PreAuthorize("hasRole('STUDENT') or hasRole('PROFESOR') or hasRole('ADMIN')")
    public CommentDto create(@PathVariable(name = "postId") Long postId, @RequestBody CommentDto commentDto) {
        Comment comment = commentService.create(postId, commentMapper.toEntity(commentDto));
        return commentMapper.toDto(comment);
    }
}
