package com.home.prodCate.controllers;

import com.home.prodCate.dto.ProductDto;
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
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Object> saveProduct(@RequestBody ProductDto personDto) { //salve //metodo. Esta dentro do service
       // Product product = new Product();
       // BeanUtils.copyProperties(personDto, product); //Converte DTO para person
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(personDto));
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping(value = "/categorie")
    public ResponseEntity<Object> saveProductCategory(@RequestBody ProductDto personDto) { //salve //metodo. Esta dentro do service
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveCategories(personDto));
    }


}
