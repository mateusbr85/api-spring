package com.avendrytech.coursespring.adapters.input.controllers;

import com.avendrytech.coursespring.core.domain.entities.OrderEntity;
import com.avendrytech.coursespring.core.domain.useCases.OrderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderUseCase orderUseCase;

    @GetMapping
    public ResponseEntity<List<OrderEntity>> findALl() {
        List<OrderEntity> listOrders = orderUseCase.findALl();
        return ResponseEntity.ok().body(listOrders);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderEntity> findById(
            @PathVariable
            Long id
    ) {
        OrderEntity order = orderUseCase.findById(id);

        return ResponseEntity.ok().body(order);
    }
}
