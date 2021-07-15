package com.degree.studyitserver.controller;

import com.degree.studyitserver.domain.dto.TutoringSessionDto;
import com.degree.studyitserver.domain.entity.TutoringSession;
import com.degree.studyitserver.mapper.TutoringSessionMapper;
import com.degree.studyitserver.service.TutoringSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tutoring-sessions")
public class TutoringSessionController {

    private final TutoringSessionService tutoringSessionService;
    private final TutoringSessionMapper tutoringSessionMapper;

    @Autowired
    public TutoringSessionController(TutoringSessionService tutoringSessionService, TutoringSessionMapper tutoringSessionMapper) {
        this.tutoringSessionService = tutoringSessionService;
        this.tutoringSessionMapper = tutoringSessionMapper;
    }

    @PostMapping("/{courseId}/create")
    @PreAuthorize("hasRole('PROFESOR') or hasRole('ADMIN')")
    public TutoringSessionDto create(@PathVariable(name = "courseId") Long courseId, @RequestBody TutoringSessionDto tutoringSessionDto) {
        TutoringSession tutoringSession = tutoringSessionService.create(courseId,
                tutoringSessionMapper.toEntity(tutoringSessionDto));
        return tutoringSessionMapper.toDto(tutoringSession);
    }

    @GetMapping("/all-by-course/{id}")
    @PreAuthorize("hasRole('STUDENT') or hasRole('PROFESOR') or hasRole('ADMIN')")
    public List<TutoringSessionDto> findAllByCourseId(@PathVariable(name = "id") Long courseId) {
        return tutoringSessionMapper.toDtos(tutoringSessionService.findAllByCourseId(courseId));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('PROFESOR') or hasRole('ADMIN')")
    public void deleteSessionById(@PathVariable(name = "id") Long id) {
        tutoringSessionService.deleteById(id);
    }
}
