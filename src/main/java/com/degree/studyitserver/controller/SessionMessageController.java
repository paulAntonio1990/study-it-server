package com.degree.studyitserver.controller;


import com.degree.studyitserver.domain.dto.SessionMessageDto;
import com.degree.studyitserver.mapper.SessionMessageMapper;
import com.degree.studyitserver.service.SessionMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/session-message")
public class SessionMessageController {

    private final SessionMessageService sessionMessageService;
    private final SessionMessageMapper sessionMessageMapper;

    @Autowired
    public SessionMessageController(SessionMessageService sessionMessageService, SessionMessageMapper sessionMessageMapper) {
        this.sessionMessageService = sessionMessageService;
        this.sessionMessageMapper = sessionMessageMapper;
    }

    @GetMapping("/by-session/{sessionId}")
    @PreAuthorize("hasRole('STUDENT') or hasRole('PROFESOR') or hasRole('ADMIN')")
    public List<SessionMessageDto> findAllBySessionId(@PathVariable Long sessionId) {
        return sessionMessageMapper.toDtos(sessionMessageService.findAllByTutoringSessionId(sessionId));
    }
}
