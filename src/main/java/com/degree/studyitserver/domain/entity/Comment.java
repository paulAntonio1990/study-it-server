package com.degree.studyitserver.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String body;

    @ManyToOne
    @JoinColumn(name="creator_id", nullable=false)
    private User creator;

    private Date date;

    @ManyToOne
    @JoinColumn(name="post_id", nullable=false)
    private Post post;
}
