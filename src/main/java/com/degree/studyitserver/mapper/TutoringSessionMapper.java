package com.degree.studyitserver.mapper;

import com.degree.studyitserver.domain.dto.TutoringSessionDto;
import com.degree.studyitserver.domain.entity.TutoringSession;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TutoringSessionMapper {

    TutoringSessionMapper INSTANCE = Mappers.getMapper(TutoringSessionMapper.class);

    TutoringSessionDto toDto(TutoringSession tutoringSession);
    TutoringSession toEntity(TutoringSessionDto tutoringSessionDto);
    List<TutoringSessionDto> toDtos(List<TutoringSession> tutoringSession);
    List<TutoringSession> toEntities(List<TutoringSessionDto> tutoringSessionDto);

}
