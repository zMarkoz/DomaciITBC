package com.rentacar.Model.Response.AdminResponseModel;

public class AdminUpdateResponseModel {
    private boolean successful;
    private String info;

    public AdminUpdateResponseModel(boolean successful,
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
