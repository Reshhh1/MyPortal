package com.example.MyPortal.service;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("/testApplication.properties")
@ExtendWith(MockitoExtension.class)
class JWTServiceTest {
    @Autowired
    JWTService jwtService;

    @Test
    void shouldSuccessfullyReturnToken() {
        String email = "test@gmail.com";
        String token = jwtService.generateToken(email);
        Assertions.assertNotNull(token);
    }

    @Test
    void shouldSuccessfullyExtractEmail() {
        String email = "test@gmail.com";
        String token = jwtService.generateToken(email);
        String actual = jwtService.extractEmail(token);
        Assertions.assertEquals(email, actual);
    }

    @Test
    @DisplayName("Should throw MalformedJwtException if the token is invalid")
    void shouldThrowMalformedExceptionIfExtractEmail() {
        String invalidToken = "FF";
        Assertions.assertThrowsExactly(
                MalformedJwtException.class,
                () -> jwtService.extractEmail(invalidToken)
        );
    }

    @Test
    @DisplayName("Should throw ExpiredJwtException if the token is invalid")
    void shouldThrowExpiredExceptionIfExtractEmail() {
        String expiredToken = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhY2NvdW50QGdtYWlsLmNvbSIsImlhdCI6MTc0NDcwMjY1MiwiZXhwIjoxNzQ0NzA0NDUyfQ.8lq_aIeecQC0GwSuMQ3x6_DibVCVF8nyw_k8P7HCGp2lEQN6_p42lyZ9Z6E4r-Nj";
        Assertions.assertThrowsExactly(
                ExpiredJwtException.class,
                () -> jwtService.extractEmail(expiredToken)
        );
    }

}