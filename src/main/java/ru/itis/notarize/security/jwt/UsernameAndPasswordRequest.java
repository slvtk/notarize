package ru.itis.notarize.security.jwt;

import lombok.Data;

@Data
public class UsernameAndPasswordRequest {
    private String username;
    private String password;
}
