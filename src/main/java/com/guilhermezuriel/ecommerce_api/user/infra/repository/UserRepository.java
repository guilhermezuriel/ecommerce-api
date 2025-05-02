package com.guilhermezuriel.ecommerce_api.user.infra.repository;

import com.guilhermezuriel.ecommerce_api.user.infra.persistence.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, String> {



}
