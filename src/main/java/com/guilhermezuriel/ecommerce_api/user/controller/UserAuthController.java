package com.guilhermezuriel.ecommerce_api.user.controller;

import com.guilhermezuriel.ecommerce_api.user.usecase.auth.dto.AuthResponseDto;
import com.guilhermezuriel.ecommerce_api.user.usecase.auth.UserAuthUseCase;
import com.guilhermezuriel.ecommerce_api.user.usecase.auth.form.AuthRequestForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
@RequiredArgsConstructor
public class UserAuthController {

    private final UserAuthUseCase userAuthUseCase;

    @PostMapping
    public ResponseEntity<AuthResponseDto> authenticateUser(@RequestBody @Valid AuthRequestForm form) {
        AuthResponseDto response = userAuthUseCase.authenticate(form);
        return ResponseEntity.ok(response);
    }

}
