package com.stfl.security;

public class SecurityConstants {
    static final String SECRET = "SecretWord123";
    static final String HEADER_STRING = "Authorization";
    static final String SIGN_UP_URL = "/users/sign_up";
    static final String SWAGGER = "/swagger-ui.html";
    static final String TOKEN_PREFIX = "Bearer ";
    static final long EXPIRATION_TIME = 864_000_000; // 10 days
}