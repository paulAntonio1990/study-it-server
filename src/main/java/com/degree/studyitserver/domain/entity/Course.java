package com.degree.studyitserver.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String domain;

    private String studyProgram;

    private Short year;

    @OneToMany(mappedBy = "course")
    private List<TutoringSession> tutoringSessions = new ArrayList<>();

    public void addTutoringSession(TutoringSession tutoringSession) {
        tutoringSessions.add(tutoringSession);
        tutoringSession.setCourse(this);
    }

    public void deleteTutoringSession(TutoringSession tutoringSession) {
        tutoringSessions.remove(tutoringSession);
        tutoringSession.setCourse(null);
    }
}
