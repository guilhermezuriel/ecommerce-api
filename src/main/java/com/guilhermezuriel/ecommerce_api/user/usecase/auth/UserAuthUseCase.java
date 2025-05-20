package com.guilhermezuriel.ecommerce_api.user.usecase.auth;

import com.guilhermezuriel.ecommerce_api._shared.config.auth.impl.CustomUserDetailsService;
import com.guilhermezuriel.ecommerce_api._shared.utils.JwtUtils;
import com.guilhermezuriel.ecommerce_api.user.usecase.auth.dto.AuthResponseDto;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAuthUseCase {

    private AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtUtils jwtUtils;

    public AuthResponseDto authenticate(String login, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, password));
        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(login);
        final String jwtToken = jwtUtils.generateToken(userDetails);
       return new AuthResponseDto(jwtToken);
    };
}
