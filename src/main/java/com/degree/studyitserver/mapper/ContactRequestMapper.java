package com.degree.studyitserver.mapper;

import com.degree.studyitserver.domain.dto.ContactRequestDto;
import com.degree.studyitserver.domain.entity.ContactRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContactRequestMapper {

    ContactRequestMapper INSTANCE = Mappers.getMapper(ContactRequestMapper.class);

    ContactRequestDto toDto(ContactRequest contactRequest);
    ContactRequest toEntity(ContactRequestDto contactRequestDto);
    List<ContactRequestDto> toDtos(List<ContactRequest> contactRequests);
    List<ContactRequest> toEntities(List<ContactRequestDto> contactRequestDtos);

}
