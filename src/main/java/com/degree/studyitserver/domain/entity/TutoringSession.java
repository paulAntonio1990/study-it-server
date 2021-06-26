package com.degree.studyitserver.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tutoring_sessions")
public class TutoringSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name="course_id", nullable=false)
    private Course course;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TutoringSession)) return false;
        return id != null && id.equals(((TutoringSession) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
