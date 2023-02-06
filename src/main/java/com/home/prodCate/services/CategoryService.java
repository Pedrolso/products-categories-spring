package com.home.prodCate.services;

import com.home.prodCate.models.Category;
import com.home.prodCate.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category) { //Metodo save
        return categoryRepository.save(category);
    }
}
