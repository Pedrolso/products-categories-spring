package com.home.prodCate.dto;

import com.home.prodCate.models.Product;

import java.util.HashSet;
import java.util.Set;

public class CategoryDto {
    private String name;
    private Set<Product> products = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
