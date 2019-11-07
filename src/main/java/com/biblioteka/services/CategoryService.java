package com.biblioteka.services;

import com.biblioteka.commons.GenericBuilder;
import com.biblioteka.entities.Category;
import com.biblioteka.entities.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addCategory(String categoryName){

        categoryRepository.save(GenericBuilder.of(Category::new)
                .with(Category::setCategoryName, categoryName)
                .build());
    }
}
