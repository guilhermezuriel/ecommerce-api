package com.guilhermezuriel.ecommerce_api.user.entity;

import com.guilhermezuriel.ecommerce_api.user.infra.persistence.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private UUID id;

    private String username;
    private String password;
    private String email;

    private String firstName;
    private String lastName;

    public static User fromPersistence(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        user.setEmail(userEntity.getEmail());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        return user;
    }

}
