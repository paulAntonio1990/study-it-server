package com.degree.studyitserver.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "chapters")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name="content_id", nullable=false)
    private Content content;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Chapter)) return false;
//        return id != null && id.equals(((Chapter) o).getId());
//    }
//
//    @Override
//    public int hashCode() {
//        return getClass().hashCode();
//    }

}
