package com.lovable_clone.account_service.service.impl;

import com.lovable_clone.account_service.dto.auth.AuthResponse;
import com.lovable_clone.account_service.dto.auth.LoginRequest;
import com.lovable_clone.account_service.dto.auth.SignupRequest;
import com.lovable_clone.account_service.entity.User;
import com.lovable_clone.account_service.mapper.UserMapper;
import com.lovable_clone.account_service.repository.UserRepository;
import com.lovable_clone.account_service.service.AuthService;
import com.lovable_clone.common_library.error.BadRequestException;
import com.lovable_clone.common_library.security.AuthUtil;
import com.lovable_clone.common_library.security.JwtUserPrincipal;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    AuthUtil authUtil;
    AuthenticationManager authenticationManager;

    @Override
    public AuthResponse signup(SignupRequest request) {
        userRepository.findByUsername(request.username()).ifPresent(user -> {
            throw new BadRequestException("User already exists with username: "+request.username());
        });

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user = userRepository.save(user);

        String token = authUtil.generateAccessToken(userMapper.toUserDto(user));
        return new AuthResponse(token, userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        JwtUserPrincipal principal = (JwtUserPrincipal) authentication.getPrincipal(); // ✅ correct cast

        User user = userRepository.findByUsername(principal.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String token = authUtil.generateAccessToken(userMapper.toUserDto(user));
        return new AuthResponse(token, userMapper.toUserProfileResponse(user));
    }
}
