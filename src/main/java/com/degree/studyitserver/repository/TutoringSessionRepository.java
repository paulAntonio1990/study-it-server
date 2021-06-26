package com.degree.studyitserver.repository;

import com.degree.studyitserver.domain.entity.TutoringSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutoringSessionRepository extends JpaRepository<TutoringSession, Long> {

    List<TutoringSession> findAllByCourse_Id(Long courseId);
}
