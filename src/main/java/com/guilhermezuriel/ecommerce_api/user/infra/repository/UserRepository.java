package com.guilhermezuriel.ecommerce_api.user.infra.repository;

import com.guilhermezuriel.ecommerce_api.user.infra.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity, String> {

    boolean existsByEmail(String email);

    Optional<UserEntity> findByEmail(String email);
}
