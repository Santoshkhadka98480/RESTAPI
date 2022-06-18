package com.example.demo.service.impl;

import com.example.demo.dto.CategoryDto;
import com.example.demo.entites.Category;
import com.example.demo.repo.CategoryRepo;
import com.example.demo.service.CategoryService;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }
    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        Category entity = Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .description(categoryDto.getDescription()).build();
        entity = categoryRepo.save(entity);
        return CategoryDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription()).build();
    }
    @Override
    public List<CategoryDto> findAll() {
        List<Category> categoryList = categoryRepo.findAll();
        return categoryList.stream().map(entity -> CategoryDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription()).build()).collect(Collectors.toList());

    }
    @Override
    public CategoryDto findById(Integer id) {
        Optional<Category> categoryOptional = categoryRepo.findById(id);
        if (categoryOptional.isPresent()) {
            Category entity = categoryOptional.get();
            return CategoryDto.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .description(entity.getDescription())
                    .build();
        }
        return null;
    }
    @Transactional
    @Modifying
    @Override
    public void delete(Integer id) {
        categoryRepo.deleteById(id);

    }
}
