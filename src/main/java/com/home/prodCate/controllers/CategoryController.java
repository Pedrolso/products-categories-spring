package com.home.prodCate.controllers;

import com.home.prodCate.dto.CategoryDto;
import com.home.prodCate.dto.ProductDto;
import com.home.prodCate.models.Category;
import com.home.prodCate.models.Product;
import com.home.prodCate.services.CategoryService;
import com.home.prodCate.services.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Object> saveCategory(@RequestBody CategoryDto categoryDto) { //salve //metodo. Esta dentro do service
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category); //Converte DTO para person
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(category));
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = categoryService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
