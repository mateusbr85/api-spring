package com.avendrytech.coursespring.adapters.input.controllers;

import com.avendrytech.coursespring.core.domain.entities.CategoryEntity;
import com.avendrytech.coursespring.core.domain.useCases.CategoryUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryUseCase categoryUseCase;

    @GetMapping
    public ResponseEntity<List<CategoryEntity>> findAll() {
        List<CategoryEntity> listCategories = categoryUseCase.findAll();

        return ResponseEntity.ok().body(listCategories);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryEntity> findById(
            @PathVariable
            Long id
    ) {
        CategoryEntity category = categoryUseCase.findById(id);

        return ResponseEntity.ok().body(category);
    }
}
