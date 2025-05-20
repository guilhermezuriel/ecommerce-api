package com.guilhermezuriel.ecommerce_api.user.domain;

import com.guilhermezuriel.ecommerce_api._shared.PublicValidator;
import com.guilhermezuriel.ecommerce_api.user.form.CreateUserForm;
import com.guilhermezuriel.ecommerce_api.user.infra.entity.UserEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record User(
        UUID id,
        @NotBlank(message = "Email must be valid")
        @Email(message = "Email must be valid")
        String email,
        @NotBlank(message = "Password must not be empty")
        @Size(min = 6, message = "Password must have more than 6 characters")
        String password,
        @NotBlank(message = "The first name must be informed")
        String firstName,
        @NotBlank(message = "The last name must be informed")
        String lastName
) {

    public User(CreateUserForm form) {
        this(UUID.randomUUID(), form.getEmail(), form.getPassword(), form.getFirstName(), form.getLastName());
        PublicValidator.validate(this, true);
    }


    public static User fromPersistence(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getFirstName(),
                userEntity.getLastName()
        );
    }
}