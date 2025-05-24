package com.guilhermezuriel.ecommerce_api.catalog.usecase.createcategory;

import com.guilhermezuriel.ecommerce_api.catalog.domain.Category;
import com.guilhermezuriel.ecommerce_api.catalog.infra.repository.CategoryRepository;
import com.guilhermezuriel.ecommerce_api.catalog.usecase.createcategory.form.CreateCategoryForm;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryUseCase {

    private final CategoryRepository categoryRepository;

    public CreateCategoryUseCase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category execute(CreateCategoryForm form) {
        //TODO -> Authorization only for admins;

        Category category = new Category(form);

        boolean existsCategoryByName = this.categoryRepository.existsByName(category.name());

        if (existsCategoryByName) {
            throw new RuntimeException("Category with the name already exists");
        }

        return category;
    }
}
