package com.rentacar.Model.Request.UserRequestModel;

public class LoginUser {
    private String identification;
    private String password;

    public LoginUser(String identification,
                     String password)
    {
        this.identification = identification;
        this.password = password;
    }

    public String getIdentification() {
        return identification;
    }

    public String getPassword() {
        return password;
    }
}
