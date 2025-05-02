package com.guilhermezuriel.ecommerce_api.user.infra.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "users")
@Data
@AllArgsConstructor
public class UserEntity {

    @Id
    private UUID id;

    private String username;
    private String password;

    private String firstName;
    private String lastName;

    private String email;

    private String refresh_token;

}
