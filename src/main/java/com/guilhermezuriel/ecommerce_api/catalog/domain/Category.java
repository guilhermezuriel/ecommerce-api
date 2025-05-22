package com.guilhermezuriel.ecommerce_api.catalog.domain;

import com.guilhermezuriel.ecommerce_api.catalog.domain.enums.CategoryTypeEnum;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record Category(
        UUID id,
        @NotBlank(message = "Category must have a name")
        String name,
        @NotNull(message = "Category must have a type")
        CategoryTypeEnum typeEnum,
        @Nullable
        String description,
        boolean active,
        @Nullable
        String color
) {
}
