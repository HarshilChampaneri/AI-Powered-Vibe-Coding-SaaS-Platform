package com.lovable_clone.account_service.security;

import com.lovable_clone.account_service.entity.User;
import com.lovable_clone.account_service.repository.UserRepository;
import com.lovable_clone.common_library.security.JwtUserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public JwtUserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return new JwtUserPrincipal(
                user.getId(),
                user.getUsername(),
                user.getPassword(), // hashed password - Spring Security uses this to verify
                new ArrayList<>()
        );
    }
}