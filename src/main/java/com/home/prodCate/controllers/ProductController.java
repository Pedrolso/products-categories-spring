package com.home.prodCate.controllers;

import com.home.prodCate.dto.ProductDto;
import com.home.prodCate.models.Product;
import com.home.prodCate.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Object> saveProduct(@RequestBody ProductDto personDto) { //salve //metodo. Esta dentro do service
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(personDto));
    }

    @PostMapping(value = "/categorie")
    public ResponseEntity<Object> saveProductCategory(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveCategories(productDto));
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable UUID id) {
        Optional<Product> personOptional = productService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(personOptional.get());
    }
}