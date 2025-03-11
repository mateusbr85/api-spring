package com.avendrytech.coursespring.adapters.input.controllers;

import com.avendrytech.coursespring.core.domain.entities.UserEntity;
import com.avendrytech.coursespring.core.domain.useCases.UserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserUseCase userUseCase;


    @GetMapping
    public ResponseEntity<List<UserEntity>> findAll() {
        List<UserEntity> list = userUseCase.findALl();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserEntity> findById(
            @PathVariable
            Long id
    ) {
        UserEntity user = userUseCase.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
