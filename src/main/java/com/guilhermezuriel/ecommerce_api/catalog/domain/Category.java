package com.guilhermezuriel.ecommerce_api.catalog.domain;

import com.guilhermezuriel.ecommerce_api._shared.utils.PublicValidator;
import com.guilhermezuriel.ecommerce_api.catalog.domain.enums.CategoryTypeEnum;
import com.guilhermezuriel.ecommerce_api.catalog.usecase.createcategory.form.CreateCategoryForm;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

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
        @Nullable @Pattern(regexp = "", message = "Color must be in HEX formart")
        String color
) {

        public Category(CreateCategoryForm form){
                this(UUID.randomUUID(), form.name(), form.typeEnum(), form.description(), form.active(), form.color());
                PublicValidator.validate(this, true);
        }
}
