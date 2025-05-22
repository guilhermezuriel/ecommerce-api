package com.guilhermezuriel.ecommerce_api.catalog.infra.repository;

import com.guilhermezuriel.ecommerce_api.catalog.infra.entity.CategoryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends MongoRepository<CategoryEntity, UUID> {
}
