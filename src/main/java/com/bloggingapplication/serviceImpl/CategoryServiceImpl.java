package com.bloggingapplication.serviceImpl;

import com.bloggingapplication.entities.Category;
import com.bloggingapplication.exceptions.ResourceNotFoundException;
import com.bloggingapplication.payloads.CategoryDto;
import com.bloggingapplication.repositories.CategoryRepo;
import com.bloggingapplication.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        Category addedCategory=modelMapper.map(categoryDto,Category.class);
        Category createdCategory=categoryRepo.save(addedCategory);
        return modelMapper.map(createdCategory,CategoryDto.class);
    }

    @Override
    public CategoryDto UpdateCategory(CategoryDto categoryDto, Integer categoryId) {
        try {
            Category category=this.categoryRepo.getReferenceById(categoryId);
            category.setCategoryDesc(categoryDto.getCategoryDesc());
            category.setCategoryTitle(categoryDto.getCategoryTitle());
            Category savedCategory=categoryRepo.save(category);
            return modelMapper.map(savedCategory,CategoryDto.class);

        } catch (ResourceNotFoundException e) {
           throw new ResourceNotFoundException("Category","Category Id",categoryId);
        }
    }

    @Override
    public void deleteCategory(Integer categoryId) {

        try{
            Category category=categoryRepo.getReferenceById(categoryId);
            categoryRepo.delete(category);
        }
        catch (ResourceNotFoundException e)
        {
            throw new ResourceNotFoundException("Category","Category Id",categoryId);
        }
    }

    @Override
    public CategoryDto getACategory(Integer categoryId) {
        try{
            Category category=categoryRepo.getReferenceById(categoryId);
            return modelMapper.map(category,CategoryDto.class);
        }
        catch (ResourceNotFoundException e)
        {
            throw new ResourceNotFoundException("Category","Category Id",categoryId);
        }
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories=categoryRepo.findAll();
        List<CategoryDto> categoryDtos=
                         categories.stream()
                        .map(category -> modelMapper.map(category,CategoryDto.class))
                        .collect(Collectors.toList());
        return categoryDtos;
    }
}
