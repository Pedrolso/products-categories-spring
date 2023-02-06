package com.home.prodCate.controllers;

import com.home.prodCate.dto.CategoryDto;
import com.home.prodCate.dto.ProductDto;
import com.home.prodCate.models.Category;
import com.home.prodCate.models.Product;
import com.home.prodCate.services.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Object> saveCategory(@RequestBody CategoryDto categoryDto) { //salve //metodo. Esta dentro do service
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category); //Converte DTO para person
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(category));
    }
}
