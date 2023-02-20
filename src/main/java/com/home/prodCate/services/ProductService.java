package com.home.prodCate.services;

import com.home.prodCate.dto.ProductDto;
import com.home.prodCate.models.Category;
import com.home.prodCate.models.Product;
import com.home.prodCate.repositories.CategoryRepository;
import com.home.prodCate.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    //NAO ESTA SALVANDO NA MESMA CATEGORIA !!!!!!!!!!!!!!!!!!!
    public Product save(ProductDto productDto) { //Salva produto e coloca em uma catehoria existente por ID
        Set<Category> listCategory = categoryRepository.findAllById(productDto.getCategories()).stream().collect(Collectors.toSet());//BUSCA NA LISTA POR ID E COLOCA NO "listCategory"
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        product.setCategories(listCategory);//produto seta todos da listaCategory para ele
        return productRepository.save(product);
    }

    public Product saveCategories(ProductDto productDto) {
        Set<Category> categories = productDto.getCategoriesDto().stream().map(
                e -> {
                    Category category = new Category();
                    BeanUtils.copyProperties(e, category);
                    return category;
                }
        ).collect(Collectors.toSet());
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        product.setCategories(categories);
        return productRepository.save(product);
    }

    public List<Product> findAll() {//Metodo Buscar todos
        return productRepository.findAll();
    }

    public Optional<Product> findById(UUID id) {
        return productRepository.findById(id);
    }
}