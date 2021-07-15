package com.degree.studyitserver.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class CourseDto {

    private Long id;
    private String name;
    private String domain;
    private String studyProgram;
    private Short year;
    private List<TutoringSessionDto> tutoringSessionDtos;
    private UserDto creator;
    private ContentDto content;
    private List<PostDto> postDtos;

}
