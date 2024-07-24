package com.codewithdurgesh.blog.blogappapis.controllers;

import com.codewithdurgesh.blog.blogappapis.payloadsDto.ApiResponse;
import com.codewithdurgesh.blog.blogappapis.payloadsDto.CategoryDto;
import com.codewithdurgesh.blog.blogappapis.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categories/api/")
public class CategoryController
{
    @Autowired
    private CategoryService categoryService;
    // create-------------------------------------

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid  @RequestBody CategoryDto categoryDto)
    {
        CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
    }

    // update ------------------------------------

    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer catId)
    {
        CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto, catId);
        return new ResponseEntity<CategoryDto>(updateCategory, HttpStatus.ACCEPTED);
    }
    //delete -------------------------------------

    @DeleteMapping("/delete/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId)
    {
        this.categoryService.deleteCategory(catId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category is delete successfully!", true), HttpStatus.ACCEPTED);
    }

    // get----------------------------------------

    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer catId)
    {
        CategoryDto categoryDto = this.categoryService.getCategory(catId);
        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.ACCEPTED);
    }

    // getAll-------------------------------------

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategory()
    {
        List<CategoryDto> categories = this. categoryService.getCategories();
        return ResponseEntity.ok(categories); 
    }

}
