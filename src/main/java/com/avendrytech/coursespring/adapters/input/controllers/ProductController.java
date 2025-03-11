package com.avendrytech.coursespring.adapters.input.controllers;

import com.avendrytech.coursespring.core.domain.entities.ProductEntity;
import com.avendrytech.coursespring.core.domain.useCases.ProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductUseCase productUseCase;

    @GetMapping
    public ResponseEntity<List<ProductEntity>> findAll() {
        return ResponseEntity.ok().body(productUseCase.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductEntity> findById(
            @PathVariable
            Long id
    ) {
        ProductEntity product = productUseCase.findById(id);
        return ResponseEntity.ok().body(product);
    }
}
