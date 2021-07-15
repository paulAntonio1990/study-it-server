package com.degree.studyitserver.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PostDto {

    private Long id;
    private String heading;
    private String body;
    private UserDto creator;
    private Date date;

}
