package com.example.demo.controller;


import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController extends BaseController{

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("create")
    public ResponseEntity<ResponseDto> createCategory(@RequestBody CategoryDto categoryDto) {
        categoryDto = categoryService.create(categoryDto);
        if (categoryDto != null) {
            return new ResponseEntity<>
                    (successResponse("Created Successfully",categoryDto), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>
                    (errorResponse("Creation Failed",null),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping
    public ResponseEntity findAll() {
        List<CategoryDto> categoryDtoList = categoryService.findAll();
        return new ResponseEntity<>
                (successResponse("Category List Fetched Successfully",categoryDtoList),HttpStatus.OK);
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable Integer id) {
        CategoryDto categoryDto = categoryService.findById(id);
        if (categoryDto != null) {
            return new ResponseEntity<>
                    (successResponse("Category Fetch",categoryDto),HttpStatus.OK);
        } else {
            return new ResponseEntity<>
                    (errorResponse("Category Fetch Failure",null),HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteById(@PathVariable Integer id) {
        categoryService.delete(id);
        return new ResponseEntity<>
                (errorResponse("Category Deleted",null), HttpStatus.BAD_REQUEST);
    }

}
