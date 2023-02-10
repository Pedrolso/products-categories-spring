package com.home.prodCate.services;

import com.home.prodCate.dto.ProductDto;
import com.home.prodCate.models.Category;
import com.home.prodCate.models.Product;
import com.home.prodCate.repositories.CategoryRepository;
import com.home.prodCate.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> findAll() {//Metodo Buscar todos
        return productRepository.findAll();
    }

    public Product save(ProductDto productDto) {
        Set<Category> listCategory = categoryRepository.findAllById(productDto.getCategories()).stream().collect(Collectors.toSet());
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        product.setCategories(listCategory);
        return productRepository.save(product);
    }

    public Product saveCategories(ProductDto productDto) {//REVER AQI
        Set<Category> cate1 = productDto.getCategoriesDto().stream().map(
                e -> {
                    Category cat = new Category();
                    BeanUtils.copyProperties(e, cat);
                    return cat;
                }
        ).collect(Collectors.toSet());

        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        product.setCategories(cate1);
        return productRepository.save(product);
    }

}

























