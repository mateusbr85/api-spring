package com.avendrytech.coursespring.adapters.input.controllers;

import com.avendrytech.coursespring.domain.entities.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<UserEntity> findAll() {
        UserEntity user = new UserEntity(1L,"mateus","mateus@mvcode.com","password");

        return ResponseEntity.ok().body(user);
    }
}
