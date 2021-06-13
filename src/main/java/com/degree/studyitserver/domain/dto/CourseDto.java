package com.degree.studyitserver.domain.dto;

import lombok.Data;

@Data
public class CourseDto {

    private Long id;
    private String name;
    private String domain;
    private String studyProgram;
    private Short year;

}
