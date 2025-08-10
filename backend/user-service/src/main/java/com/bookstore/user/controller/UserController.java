package com.bookstore.user.controller;

import com.bookstore.user.dto.UserDTO;
import com.bookstore.user.model.User;
import com.bookstore.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody UserDTO dto) {
        return ResponseEntity.ok(service.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserDTO dto) {
        boolean success = service.login(dto.getEmail(), dto.getPassword());
        return success ? ResponseEntity.ok("Login successful")
                       : ResponseEntity.status(401).body("Invalid credentials");
    }
}