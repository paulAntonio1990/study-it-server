package com.degree.studyitserver.domain.payload.response;

import lombok.Data;

@Data
public class JWTTokenResponse {

    private String token;

    private String type = "Bearer ";

    private Long id;

    private String userName;

    private String email;

    private String role;

    public JWTTokenResponse(String token, Long id, String userName, String email, String role) {
        this.token = token;
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.role = role;
    }
}
