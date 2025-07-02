package com.security.auth_validation.model;

public class User {
    private String username;
    private String password;
    private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public void setPassword(String encode) {
    }

    public CharSequence getPassword() {
        return password;
    }
}
