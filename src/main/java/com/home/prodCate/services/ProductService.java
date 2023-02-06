package com.home.prodCate.services;

import com.home.prodCate.models.Product;
import com.home.prodCate.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product) {//Metodo save
        return productRepository.save(product);
    }

    public List<Product> findAll() {//Metodo Buscar todos
        return productRepository.findAll();
    }
}
