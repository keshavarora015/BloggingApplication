package com.bloggingapplication.controllers;

import com.bloggingapplication.payloads.ApiResponse;
import com.bloggingapplication.payloads.CategoryDto;
import com.bloggingapplication.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    //Create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto)
    {
        CategoryDto createdCategory =categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createdCategory,HttpStatus.CREATED);
    }

    //Update
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory( @Valid @RequestBody CategoryDto categoryDto,@PathVariable("categoryId") Integer categoryId )
    {
        CategoryDto updatedCategory =categoryService.UpdateCategory(categoryDto,categoryId);
        return new ResponseEntity<CategoryDto>(updatedCategory,HttpStatus.CREATED);
    }

    //Delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("categoryId") Integer categoryId)
    {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
    }
    //get a single category
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getACategory(@PathVariable ("categoryId") Integer categoryId)
    {
        CategoryDto aCategory=categoryService.getACategory(categoryId);
        return new ResponseEntity<CategoryDto>(aCategory,HttpStatus.OK) ;
    }

    //get all categories
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategory()
    {
        List<CategoryDto> allCategory=categoryService.getAllCategory();
        return new ResponseEntity<List<CategoryDto>>(allCategory,HttpStatus.OK) ;
    }

}
