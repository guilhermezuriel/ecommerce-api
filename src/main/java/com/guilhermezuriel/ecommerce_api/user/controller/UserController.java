package com.guilhermezuriel.ecommerce_api.user.controller;

import com.guilhermezuriel.ecommerce_api.user.usecase.subscribe.form.CreateUserForm;
import com.guilhermezuriel.ecommerce_api.user.usecase.subscribe.SubscribeUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserController {

    private final SubscribeUserUseCase subscribeUserUseCase;

    @PostMapping
    public ResponseEntity<Void> subscribeUser(@RequestBody CreateUserForm form) {
        this.subscribeUserUseCase.subscribe(form);
        return ResponseEntity.noContent().build();
    }


}
