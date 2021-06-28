package com.degree.studyitserver.repository;

import com.degree.studyitserver.domain.entity.SessionMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionMessageRepository extends JpaRepository<SessionMessage, Long> {

    List<SessionMessage> findAllByTutoringSession_Id(Long sessionId);
}
