package com.avendrytech.coursespring.core.ports.output.repositories;

import com.avendrytech.coursespring.core.domain.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<OrderEntity, Long> {
}
