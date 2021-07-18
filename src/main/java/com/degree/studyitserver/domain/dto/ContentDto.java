package com.degree.studyitserver.domain.dto;

import lombok.Data;

import java.util.List;


@Data
public class ContentDto {

    private Long id;
    private String shortDescription;
    private String longDescription;
    private List<ChapterDto> chapters;

}
