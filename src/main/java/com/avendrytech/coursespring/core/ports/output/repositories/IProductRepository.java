package com.avendrytech.coursespring.core.ports.output.repositories;

import com.avendrytech.coursespring.core.domain.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<ProductEntity, Long> {
}
