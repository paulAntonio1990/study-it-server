package com.degree.studyitserver.service;

import com.degree.studyitserver.domain.dto.SessionMessageDto;
import com.degree.studyitserver.domain.entity.SessionMessage;
import com.degree.studyitserver.domain.entity.TutoringSession;
import com.degree.studyitserver.domain.entity.User;
import com.degree.studyitserver.repository.SessionMessageRepository;
import com.degree.studyitserver.repository.TutoringSessionRepository;
import com.degree.studyitserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class SessionMessageService {

    private final SessionMessageRepository sessionMessageRepository;
    private final UserRepository userRepository;
    private final TutoringSessionRepository tutoringSessionRepository;

    @Autowired
    public SessionMessageService(SessionMessageRepository sessionMessageRepository,
                                 UserRepository userRepository,
                                 TutoringSessionRepository tutoringSessionRepository) {
        this.sessionMessageRepository = sessionMessageRepository;
        this.userRepository = userRepository;
        this.tutoringSessionRepository = tutoringSessionRepository;
    }

    public SessionMessage processMessage(SessionMessageDto sessionMessageDto) {
        User user = userRepository.findById(sessionMessageDto.getUser().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid User ID!"));

        TutoringSession tutoringSession = tutoringSessionRepository.findById(sessionMessageDto.getSessionId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid tutoring session ID!"));

        SessionMessage message = new SessionMessage();
        message.setMessage(sessionMessageDto.getMessage());
        message.setUser(user);
        message.setTutoringSession(tutoringSession);
        message.setDate(new Date());

        return create(message);
    }

    public SessionMessage create(SessionMessage sessionMessage) {
        return sessionMessageRepository.save(sessionMessage);
    }

    public List<SessionMessage> findAllByTutoringSessionId(Long sessionId) {
        return sessionMessageRepository.findAllByTutoringSession_Id(sessionId);
    }
}
