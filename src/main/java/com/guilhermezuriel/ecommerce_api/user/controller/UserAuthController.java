package com.guilhermezuriel.ecommerce_api.user.controller;

import com.guilhermezuriel.ecommerce_api.user.usecase.auth.dto.AuthResponseDto;
import com.guilhermezuriel.ecommerce_api.user.usecase.auth.UserAuthUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController("/auth")
@RequiredArgsConstructor
public class UserAuthController {

    private final UserAuthUseCase userAuthUseCase;

    public ResponseEntity<AuthResponseDto> authenticateUser(String username, String password) {
        AuthResponseDto response = userAuthUseCase.authenticate(username, password);
        return ResponseEntity.ok(response);
    }

}
