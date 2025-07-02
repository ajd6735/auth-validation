package com.security.auth_validation;

import com.security.auth_validation.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<String, User> users = new HashMap<>();
    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    public User findByUsername(String username) {
        return users.get(username);
    }

    public Map<String, User> getAllUsers() {
        return users;
    }
}
