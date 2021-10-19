package com.rentacar.Model.Response.UserResponse;

public class UserLoginResponseModel {
    private boolean successful;
    private String info;

    public UserLoginResponseModel(boolean successful,
                                  String info)
    {
        this.successful = successful;
        this.info = info;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public String getInfo() {
        return info;
    }
}

