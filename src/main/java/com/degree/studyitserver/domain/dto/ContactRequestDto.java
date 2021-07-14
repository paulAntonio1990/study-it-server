package com.degree.studyitserver.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ContactRequestDto {

    private Long id;
    private String email;
    private String content;
    private Date date;

}
