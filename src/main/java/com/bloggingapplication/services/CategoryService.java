package com.bloggingapplication.services;

import com.bloggingapplication.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    //Create
    CategoryDto createCategory(CategoryDto categoryDto);

    //Update
    CategoryDto UpdateCategory(CategoryDto categoryDto, Integer categoryId);

    //Delete
    void deleteCategory(Integer categoryId);

    //Get
    CategoryDto getACategory(Integer categoryId);

    //GetAll
    List<CategoryDto> getAllCategory();


}
