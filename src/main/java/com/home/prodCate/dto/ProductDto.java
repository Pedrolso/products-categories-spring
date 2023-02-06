package com.home.prodCate.dto;

import com.home.prodCate.models.Category;

import java.util.HashSet;
import java.util.Set;

public class ProductDto {

    private String name;
    private Double price;
    private Set<Category> categories = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
