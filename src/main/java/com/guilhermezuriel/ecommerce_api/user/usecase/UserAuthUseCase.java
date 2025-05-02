package com.guilhermezuriel.ecommerce_api.user.usecase;

import com.guilhermezuriel.ecommerce_api.user.infra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAuthUseCase {

    private final UserRepository userRepository;

    public String authenticate(String login, String password) {
       return "";
    };
}
