package com.rentacar.Dao;

import com.rentacar.Model.Response.AdminUpdateUserModel;
import com.rentacar.Model.Response.RegisterUserModel;
import com.rentacar.Model.Response.UpdateUserModel;
import com.rentacar.Model.Response.UserResponse.GetUserResponseModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoSQL implements UserDao {
    private static PreparedStatement preparedStatement;
    private static Statement statement;

    @Override
    public boolean userNameTaken(String username) {

        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE " + " username = '" + username + "';");

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean emailExists(String email) {
        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE " + " email = '" + email + "';");

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getPasswordWithApproval(String identification) {

        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT password FROM users WHERE " + " email = '" + identification + "' OR username = '" + identification + "';");

            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public String getPasswordWithUUID(String id) {

        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT password FROM users WHERE " + " user_id = '" + id + "';");

            rs.next();
            return rs.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public GetUserResponseModel getUser(String id) {

        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT username, email, first_name, " +  " last_name, phone_number, personal_number, image FROM users WHERE " +
                    " user_id = '" + id + "';");

            rs.next();
            return new GetUserResponseModel
                            (rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isAdmin(String id) {
        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT admin FROM users WHERE " +  " user_id = '" + id + "';");

            rs.next();
            return rs.getBoolean(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<GetUserResponseModel> getAllUsers() {
        List<GetUserResponseModel> users = new ArrayList<>();
        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT username, email, first_name, " + " last_name, phone_number, personal_number, image FROM users ;");

            while (rs.next()) {
                users.add(new GetUserResponseModel(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7)));
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void registerUser(RegisterUserModel user) {
        try {
            preparedStatement = conn.prepareStatement("INSERT INTO users" + " (user_id, username, email, password, admin)" +
                    " VALUES(?, ?, ?, ?, ?)");

            preparedStatement.setString(1, user.getId().toString());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setBoolean(5, user.isAdmin());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(UpdateUserModel user, String id) {
        try {
            preparedStatement = conn.prepareStatement(" UPDATE users " +
                    " SET username = ?," +
                    " password = ?," +
                    " first_name = ?," +
                    " last_name = ?," +
                    " phone_number = ?," +
                    " image = ?" +
                    " WHERE user_id = '" + id + "';");
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT username, password, first_name," +
                    " last_name, phone_number, image FROM users " +
                    " WHERE user_id = '" + id + "';");
            rs.next();

            if (user.getUsername().isEmpty())
                preparedStatement.setString(1, rs.getString(1));
            else
                preparedStatement.setString(1, user.getUsername());

            if (user.getPassword().isEmpty())
                preparedStatement.setString(2, rs.getString(2));
            else
                preparedStatement.setString(2, user.getPassword());

            if (user.getFirstName().isEmpty())
                preparedStatement.setString(3, rs.getString(3));
            else
                preparedStatement.setString(3, user.getFirstName());

            if (user.getLastName().isEmpty())
                preparedStatement.setString(4, rs.getString(4));
            else
                preparedStatement.setString(4, user.getLastName());

            if (user.getPhoneNumber().isEmpty())
                preparedStatement.setString(5, rs.getString(5));
            else
                preparedStatement.setString(5, user.getPhoneNumber());

            if (user.getImage().isEmpty())
                preparedStatement.setString(6, rs.getString(6));
            else
                preparedStatement.setString(6, user.getImage());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void adminUpdateUserInfo(AdminUpdateUserModel user, String id) {
//
        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT username, email, first_name," +
                    " last_name, phone_number, personal_number, image FROM users " +
                    " WHERE user_id = '" + id + "'");

            preparedStatement = conn.prepareStatement(" UPDATE users " +
                    " SET username = ?," +
                    " email = ?," +
                    " first_name = ?," +
                    " last_name = ?," +
                    " phone_number = ?," +
                    " personal_number = ?," +
                    " image = ?" +
                    " WHERE user_id = '" + id + "'");

            if (rs.next()) {
                if (user.getUsername().isEmpty())
                    preparedStatement.setString(1, rs.getString(1));
                else
                    preparedStatement.setString(1, user.getUsername());

                if (user.getEmail().isEmpty())
                    preparedStatement.setString(2, rs.getString(2));
                else
                    preparedStatement.setString(2, user.getEmail());

                if (user.getFirstName().isEmpty())
                    preparedStatement.setString(3, rs.getString(3));
                else
                    preparedStatement.setString(3, user.getFirstName());

                if (user.getLastName().isEmpty())
                    preparedStatement.setString(4, rs.getString(4));
                else
                    preparedStatement.setString(4, user.getLastName());

                if (user.getPhoneNumber().isEmpty())
                    preparedStatement.setString(5, rs.getString(5));
                else
                    preparedStatement.setString(5, user.getPhoneNumber());

                if (user.getPersonalNumber().isEmpty())
                    preparedStatement.setString(6, rs.getString(6));
                else
                    preparedStatement.setString(6, user.getPersonalNumber());

                if (user.getImage().isEmpty())
                    preparedStatement.setString(7, rs.getString(7));
                else
                    preparedStatement.setString(7, user.getImage());
                preparedStatement.executeUpdate();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
