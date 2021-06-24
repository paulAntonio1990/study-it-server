package com.degree.studyitserver.domain.payload.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginRequest {

    @NotEmpty
    private String userName;

    @NotEmpty
    private String password;

}
