package com.degree.studyitserver.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SessionMessageDto {
    private Long id;
    private Long sessionId;
    private String message;
    private UserDto user;
    private Date date;
}
