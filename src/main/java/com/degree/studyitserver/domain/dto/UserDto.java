package com.degree.studyitserver.domain.dto;

import lombok.Data;


@Data
public class UserDto {

    private Long id;
    private String userName;
    private String email;
    private String role;

}
