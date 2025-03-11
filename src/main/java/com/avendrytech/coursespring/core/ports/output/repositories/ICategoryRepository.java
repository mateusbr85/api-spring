package com.avendrytech.coursespring.core.ports.output.repositories;

import com.avendrytech.coursespring.core.domain.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
