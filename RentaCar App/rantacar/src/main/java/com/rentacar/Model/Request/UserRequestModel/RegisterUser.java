package com.rentacar.Model.Request.UserRequestModel;

public class RegisterUser {
    private String username, email, password;

    public RegisterUser(String username,
                        String email,
                        String password)
    {
        this.username = username;
        this.email = email;
        this.password = password;
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
}
