package com.degree.studyitserver.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contents")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shortDescription;

    private String longDescription;

    @OneToOne(mappedBy = "content")
    private Course course;
}
