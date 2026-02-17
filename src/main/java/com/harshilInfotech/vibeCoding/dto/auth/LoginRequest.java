package com.harshilInfotech.vibeCoding.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(

        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Please enter the valid email")
        String username,

        @Size(min = 4, max = 50, message = "Minimum 4 and Maximum 50 characters are required")
        String password
) {
}