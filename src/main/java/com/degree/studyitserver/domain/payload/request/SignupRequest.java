package com.degree.studyitserver.domain.payload.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class SignupRequest {

    @NotEmpty
    @Size(min = 3, max = 42)
    private String userName;

    @NotEmpty
    @Email
    @Size(max = 100)
    private String email;

    @NotEmpty
    @Size(min = 4, max = 15)
    private String password;

    private String role;
}
