package com.rentacar.Dao;

import com.rentacar.Connection.DbConnection;
import com.rentacar.Model.Response.AdminUpdateUserModel;
import com.rentacar.Model.Response.RegisterUserModel;
import com.rentacar.Model.Response.UpdateUserModel;
import com.rentacar.Model.Response.UserResponse.GetUserResponseModel;

import java.sql.Connection;
import java.util.List;

public interface UserDao {
    Connection conn = DbConnection.getConnection();

    boolean userNameTaken(String username);

    boolean emailExists(String email);

    String getPasswordWithApproval(String identification);

    String getPasswordWithUUID(String id);

    GetUserResponseModel getUser(String id);

    boolean isAdmin(String id);

    List<GetUserResponseModel> getAllUsers();

    void registerUser(RegisterUserModel user);

    void updateUser(UpdateUserModel user, String id);

    void adminUpdateUserInfo(AdminUpdateUserModel user, String id);


}
