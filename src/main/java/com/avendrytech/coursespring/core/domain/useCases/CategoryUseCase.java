package com.avendrytech.coursespring.core.domain.useCases;

import com.avendrytech.coursespring.core.domain.entities.CategoryEntity;
import com.avendrytech.coursespring.core.ports.output.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryUseCase {

    @Autowired
    ICategoryRepository categoryRepository;

    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }

    public CategoryEntity findById(Long id) {
        Optional<CategoryEntity> category = categoryRepository.findById(id);

        return category.get();
    }
}
