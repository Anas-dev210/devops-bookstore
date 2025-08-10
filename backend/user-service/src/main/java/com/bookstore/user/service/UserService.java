package com.bookstore.user.service;

import com.bookstore.user.dto.UserDTO;
import com.bookstore.user.model.User;
import com.bookstore.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User register(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); // 🔐 Hash in future
        return repo.save(user);
    }

    public boolean login(String email, String password) {
        return repo.findByEmail(email)
                   .map(user -> user.getPassword().equals(password))
                   .orElse(false);
    }
}