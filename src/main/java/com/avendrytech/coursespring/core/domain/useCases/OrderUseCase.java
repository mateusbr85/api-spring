package com.avendrytech.coursespring.core.domain.useCases;

import com.avendrytech.coursespring.core.domain.entities.OrderEntity;
import com.avendrytech.coursespring.core.ports.output.repositories.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderUseCase {

    @Autowired
    IOrderRepository orderRepository;

    public List<OrderEntity> findALl() {
        return orderRepository.findAll();
    }

    public OrderEntity findById(Long id) {
        Optional<OrderEntity> order = orderRepository.findById(id);
        return order.get();
    }
}
