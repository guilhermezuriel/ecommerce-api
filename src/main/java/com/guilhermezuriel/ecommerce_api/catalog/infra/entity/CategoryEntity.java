package com.guilhermezuriel.ecommerce_api.catalog.infra.entity;

import com.guilhermezuriel.ecommerce_api.catalog.domain.enums.CategoryTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "catalog")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryEntity {
    @Id
    private UUID id;

    private String name;
    private String description;

    private CategoryTypeEnum type;
    private String color;

    private boolean active;
}
