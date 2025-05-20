package com.guilhermezuriel.ecommerce_api.user.usecase.auth;

import com.guilhermezuriel.ecommerce_api._shared.config.auth.impl.CustomUserDetailsService;
import com.guilhermezuriel.ecommerce_api._shared.utils.JwtUtils;
import com.guilhermezuriel.ecommerce_api.user.usecase.auth.dto.AuthResponseDto;
import com.guilhermezuriel.ecommerce_api.user.usecase.auth.form.AuthRequestForm;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAuthUseCase {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtUtils jwtUtils;

    public AuthResponseDto authenticate(AuthRequestForm form) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(form.login(), form.password()));
        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(form.login());
        final String jwtToken = jwtUtils.generateToken(userDetails.getUsername());
       return new AuthResponseDto(jwtToken);
    };
}
