package com.codewithdurgesh.blog.blogappapis.service;

import com.codewithdurgesh.blog.blogappapis.payloadsDto.CategoryDto;

import java.util.List;


public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
    void deleteCategory(Integer categoryId);
    CategoryDto getCategory(Integer categoryId);
    List<CategoryDto> getCategories();

}
