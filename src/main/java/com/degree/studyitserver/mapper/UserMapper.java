package com.degree.studyitserver.mapper;

import com.degree.studyitserver.domain.dto.TutoringSessionDto;
import com.degree.studyitserver.domain.dto.UserDto;
import com.degree.studyitserver.domain.entity.TutoringSession;
import com.degree.studyitserver.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(User user);
    User toEntity(UserDto userDto);
    List<UserDto> toDtos(List<User> users);
    List<User> toEntities(List<UserDto> userDtos);
}
