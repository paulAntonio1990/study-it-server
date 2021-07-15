package com.degree.studyitserver.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDto {

    private Long id;
    private String body;
    private UserDto creator;
    private Date date;

}
