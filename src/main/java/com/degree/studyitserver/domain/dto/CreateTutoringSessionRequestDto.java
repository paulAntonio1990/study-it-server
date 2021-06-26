package com.degree.studyitserver.domain.dto;

import lombok.Data;

@Data
public class CreateTutoringSessionRequestDto {
    private Long courseId;
    private TutoringSessionDto tutoringSessionDto;
}
