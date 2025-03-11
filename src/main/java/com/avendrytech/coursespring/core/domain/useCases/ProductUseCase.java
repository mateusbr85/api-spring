package com.avendrytech.coursespring.core.domain.useCases;

import com.avendrytech.coursespring.core.domain.entities.ProductEntity;
import com.avendrytech.coursespring.core.ports.output.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductUseCase {

    @Autowired
    private IProductRepository productRepository;

    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    public ProductEntity findById(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);

        return product.get();
    }
}
