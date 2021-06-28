package com.degree.studyitserver.mapper;

import com.degree.studyitserver.domain.dto.SessionMessageDto;
import com.degree.studyitserver.domain.entity.SessionMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {UserMapper.class, TutoringSessionMapper.class})
public interface SessionMessageMapper {

    SessionMessageMapper INSTANCE = Mappers.getMapper(SessionMessageMapper.class);

    @Mapping(source = "sessionMessage.tutoringSession.id", target = "sessionId")
    SessionMessageDto toDto(SessionMessage sessionMessage);

    List<SessionMessageDto> toDtos(List<SessionMessage> sessionMessages);
}
