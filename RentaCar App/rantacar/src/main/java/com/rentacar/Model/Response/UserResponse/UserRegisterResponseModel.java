package com.rentacar.Model.Response.UserResponse;

public class UserRegisterResponseModel {
    private boolean successful;
    private String message;

    public UserRegisterResponseModel(boolean successful,
                                     String message)
    {
        this.successful = successful;
        this.message = message;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public String getMessage() {
        return message;
    }
}


