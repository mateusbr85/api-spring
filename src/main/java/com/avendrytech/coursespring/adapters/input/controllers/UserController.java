package com.avendrytech.coursespring.adapters.input.controllers;

import com.avendrytech.coursespring.domain.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L,"mateus","mateus@mvcode.com","password");

        return ResponseEntity.ok().body(user);
    }
}
