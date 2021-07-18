package com.degree.studyitserver.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "content")
    private List<Chapter> chapters = new ArrayList<>();

    public void addChapter(Chapter chapter) {
        chapters.add(chapter);
        chapter.setContent(this);
    }

    public void deleteChapter(Chapter chapter) {
        chapters.remove(chapter);
        chapter.setContent(null);
    }
}
