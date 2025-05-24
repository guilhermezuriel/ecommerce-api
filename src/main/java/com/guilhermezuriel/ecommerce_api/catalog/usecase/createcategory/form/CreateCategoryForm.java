package com.guilhermezuriel.ecommerce_api.catalog.usecase.createcategory.form;

import com.guilhermezuriel.ecommerce_api.catalog.domain.enums.CategoryTypeEnum;

public record CreateCategoryForm(
        String name,
        CategoryTypeEnum typeEnum,
        String description,
        boolean active,
        String color
) {
}
