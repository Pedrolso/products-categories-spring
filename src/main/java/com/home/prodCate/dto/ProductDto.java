package com.home.prodCate.dto;

import com.home.prodCate.models.Category;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ProductDto {

    private String name;
    private Double price;
    private Set<UUID> categories = new HashSet<>();
    private Set<CategoryDto> categoriesDto = new HashSet<>();

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

    public Set<UUID> getCategories() {
        return categories;
    }

    public void setCategories(Set<UUID> categories) {
        this.categories = categories;
    }

    public Set<CategoryDto> getCategoriesDto() {
        return categoriesDto;
    }

    public void setCategoriesDto(Set<CategoryDto> categoriesDto) {
        this.categoriesDto = categoriesDto;
    }
}
