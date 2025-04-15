package com.example.MyPortal.user.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterForm(
        @NotBlank(message = "email field is required")
        @Email(message = "invalid email")
        String email,
        @NotBlank(message = "password field required")
        String password
)
{
    public RegisterForm(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
