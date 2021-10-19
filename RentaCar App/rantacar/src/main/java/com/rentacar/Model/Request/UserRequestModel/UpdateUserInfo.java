package com.rentacar.Model.Request.UserRequestModel;

public class UpdateUserInfo {
    private String username, password, newPassword, firstName, lastName;
    private String phoneNumber, image;

    public UpdateUserInfo(String username,
                          String password,
                          String newPassword,
                          String firstName,
                          String lastName,
                          String phoneNumber,
                          String image)
    {
        this.username = username;
        this.password = password;
        this.newPassword = newPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getImage() {
        return image;
    }
}
