package rs.itbootcamp.dao;

import rs.itbootcamp.connection.DatabaseConnection;
import rs.itbootcamp.model.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoSQL implements UserDao {
    static Connection conn = DatabaseConnection.getConnection();

    @Override
    public void add(UserModel user) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO User " + " VALUES(?, ?, ?, ?, ?)");
            st.setInt(1, user.getUserId());
            st.setString(2, user.getUserName());
            st.setString(3, user.getEmail());
            st.setString(4, user.getPassword());
            st.setBoolean(5, user.isAdmin());
            st.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM User WHERE user_id = ?;");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void update(UserModel user) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE User" +
                    "SET user_id = ?," +
                    "user_name = ?," +
                    "user_email = ?," +
                    "user_password = ?," +
                    "user_adim = ?,");
            st.setInt(1, user.getUserId());
            st.setString(2, user.getUserName());
            st.setString(3, user.getEmail());
            st.setString(4, user.getPassword());
            st.setBoolean(5, user.isAdmin());
            st.executeUpdate();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public UserModel getUser(int id) {
        List<String> newUser = null;

        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM User WHERE user_id = " + id);

            newUser = new ArrayList<>();
            while (rs.next()){
                int u1 = rs.getInt(1);
                String u2 = rs.getString(2);
                String u3 = rs.getString(3);
                String u4 = rs.getString(4);
                Boolean u5 = rs.getBoolean(5);
                UserModel user =  new UserModel(u1, u2, u3, u4, u5);

                user.setUserId(u1);
                user.setUserName(u2);
                user.setEmail(u3);
                user.setPassword(u4);
                user.setAdmin(u5);
            }


        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return null;

    }
}
