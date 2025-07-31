package com.example.fitnessapp.service;

import com.example.fitnessapp.dto.*;
import com.example.fitnessapp.model.User;
import com.example.fitnessapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.email)) throw new RuntimeException("Email already exists");
        User user = new User();
        user.setName(request.name);
        user.setEmail(request.email);
        user.setPassword(request.password);
        userRepository.save(user);
    }

    public LoginResponse login(LoginRequest request) {
        boolean valid = userRepository.findByEmailAndPassword(request.email, request.password).isPresent();
        if (!valid) throw new RuntimeException("Invalid credentials");
        return new LoginResponse("Login successful");
    }
}
