package com.lovable_clone.account_service.service;


import com.lovable_clone.account_service.dto.auth.AuthResponse;
import com.lovable_clone.account_service.dto.auth.LoginRequest;
import com.lovable_clone.account_service.dto.auth.SignupRequest;

public interface AuthService {
    AuthResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);
}
