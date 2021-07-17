package com.degree.studyitserver.controller;

import com.degree.studyitserver.domain.dto.PostDto;
import com.degree.studyitserver.domain.entity.Post;
import com.degree.studyitserver.mapper.PostMapper;
import com.degree.studyitserver.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/posts")
public class PostController {

    private final PostService postService;
    private final PostMapper postMapper;

    @Autowired
    public PostController(PostService postService, PostMapper postMapper) {
        this.postService = postService;
        this.postMapper = postMapper;
    }

    @PostMapping("/{courseId}/create")
    @PreAuthorize("hasRole('STUDENT') or hasRole('PROFESOR') or hasRole('ADMIN')")
    public PostDto create(@PathVariable(name = "courseId") Long courseId, @RequestBody PostDto postDto) {
        Post post = postService.create(courseId, postMapper.toEntity(postDto));
        return postMapper.toDto(post);
    }

    @GetMapping("/all-by-course/{courseId}")
    @PreAuthorize("hasRole('STUDENT') or hasRole('PROFESOR') or hasRole('ADMIN')")
    public List<PostDto> findAllByCourseId(@PathVariable(name = "courseId") Long courseId) {
        return postMapper.toDtos(postService.findAllByCourseId(courseId));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('STUDENT') or hasRole('PROFESOR') or hasRole('ADMIN')")
    public void deletePostById(@PathVariable(name = "id") Long id) {
        postService.deleteById(id);
    }
}
