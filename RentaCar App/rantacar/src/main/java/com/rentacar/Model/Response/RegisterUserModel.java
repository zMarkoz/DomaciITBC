package com.rentacar.Model.Response;

import java.util.UUID;

public class RegisterUserModel {
    private UUID id;
    private String username, email, password;
    private boolean admin;

    public RegisterUserModel(String username, String email, String password) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.email = email;
        this.password = password;
        this.admin = false;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return admin;
    }
}

