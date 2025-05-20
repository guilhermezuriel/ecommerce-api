package com.guilhermezuriel.ecommerce_api.user.usecase.subscribe;

import com.guilhermezuriel.ecommerce_api.user.domain.User;
import com.guilhermezuriel.ecommerce_api.user.infra.entity.UserEntity;
import com.guilhermezuriel.ecommerce_api.user.infra.repository.UserRepository;
import com.guilhermezuriel.ecommerce_api.user.usecase.subscribe.form.CreateUserForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscribeUserUseCase {

    private final UserRepository userRepository;

    public void subscribe(CreateUserForm form) {
        UserEntity userEntity = new UserEntity();

        User newUser = new User(form);
        boolean verifyIfEmailExists = this.userRepository.existsByEmail(newUser.email());

        if(verifyIfEmailExists) {
            throw new RuntimeException("Email already exists");
        }

        userEntity.setEmail(newUser.email());

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userEntity.setPassword(bCryptPasswordEncoder.encode(newUser.password()));

        userEntity.setFirstName(newUser.firstName());
        userEntity.setLastName(newUser.lastName());

        this.userRepository.save(userEntity);

    }
}
