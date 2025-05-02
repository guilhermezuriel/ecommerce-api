package com.guilhermezuriel.ecommerce_api.user.controller;

import com.guilhermezuriel.ecommerce_api.user.usecase.UserAuthUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController("/auth")
@RequiredArgsConstructor
public class UserAuthController {

    private final UserAuthUseCase userAuthUseCase;

    public ResponseEntity<String> authenticateUser(String username, String password) {
        String token = userAuthUseCase.authenticate(username, password);
        return ResponseEntity.ok(token);
    }

}
