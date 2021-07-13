package com.degree.studyitserver.mapper;

import com.degree.studyitserver.domain.dto.UserDto;
import com.degree.studyitserver.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "role.name", target = "role")
    UserDto toDto(User user);

    @Mapping(target = "role", ignore = true)
    User toEntity(UserDto userDto);
    List<UserDto> toDtos(List<User> users);
    List<User> toEntities(List<UserDto> userDtos);
}
