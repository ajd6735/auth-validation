package com.security.auth_validation;

import com.security.auth_validation.model.AppUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<String, AppUser> users = new HashMap<>();
    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(AppUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    public AppUser findByUsername(String username) {
        return users.get(username);
    }

    public Map<String, AppUser> getAllUsers() {
        return users;
    }
}
