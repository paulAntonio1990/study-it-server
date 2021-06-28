package com.degree.studyitserver.controller;

import com.degree.studyitserver.domain.dto.SessionMessageDto;
import com.degree.studyitserver.mapper.SessionMessageMapper;
import com.degree.studyitserver.service.SessionMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@Controller
public class WebSocketTutoringSessionController {

    private final SessionMessageService sessionMessageService;
    private final SessionMessageMapper sessionMessageMapper;

    @Autowired
    public WebSocketTutoringSessionController(SessionMessageService sessionMessageService, SessionMessageMapper sessionMessageMapper) {
        this.sessionMessageService = sessionMessageService;
        this.sessionMessageMapper = sessionMessageMapper;
    }

    @MessageMapping("/resume")
    @SendTo("/start/initial")
    public SessionMessageDto chat(SessionMessageDto sessionMessageDto) {
        return sessionMessageMapper.toDto(sessionMessageService.processMessage(sessionMessageDto));
    }
}
