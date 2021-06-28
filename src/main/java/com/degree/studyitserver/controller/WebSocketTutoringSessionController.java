package com.degree.studyitserver.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@Controller
public class WebSocketTutoringSessionController {

    @MessageMapping("/resume")
    @SendTo("/start/initial")
    public String chat(String msg) {
        return msg;
    }
}
