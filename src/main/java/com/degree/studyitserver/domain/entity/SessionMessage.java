package com.degree.studyitserver.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "session_messages")
public class SessionMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="session_id", nullable=false)
    private TutoringSession tutoringSession;

    private Date date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SessionMessage)) return false;
        return id != null && id.equals(((SessionMessage) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
