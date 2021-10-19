package com.rentacar.Model.Response.UserResponse;

public class UserUpdateResponseModel {
    private boolean successful;
    private String info;

    public UserUpdateResponseModel(boolean successful,
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

