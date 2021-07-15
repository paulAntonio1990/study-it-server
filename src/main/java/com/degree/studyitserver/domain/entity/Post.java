package com.degree.studyitserver.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String heading;

    private String body;

    @ManyToOne
    @JoinColumn(name="creator_id", nullable=false)
    private User creator;

    private Date date;

    @ManyToOne
    @JoinColumn(name="course_id", nullable=false)
    private Course course;
}
