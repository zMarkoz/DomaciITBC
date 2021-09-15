package rs.itbootcamp.dao;

import rs.itbootcamp.connection.DatabaseConnection;
import rs.itbootcamp.model.FoodModel;

import java.sql.*;
import java.util.ArrayList;

import java.util.List;


public class FoodDaoSQL implements FoodDao {

    static Connection conn = DatabaseConnection.getConnection();

    @Override
    public void insert(FoodModel fm) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO food" + "VALUES(?, ?, ?, ?, ?, ?)");
            st.setInt(1, fm.getFood_id());
            st.setString(2, fm.getFood_name());
            st.setDouble(3, fm.getFood_kcal());
            st.setDouble(4, fm.getFood_proteins());
            st.setDouble(5, fm.getFood_carbohydrates());
            st.setDouble(6, fm.getFood_fat());
            st.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {

        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM food WHERE food_id = ?;");
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    @Override
    public void update(FoodModel fm) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE food " +
                    "SET food_id = ?, " +
                    "food_name = ?, " +
                    "food_kcal = ?, " +
                    "food_proteins = ?, " +
                    "food_carbs = ?, " +
                    "food_fat = ? " +
                    "WHERE food_id = ?");

            st.setInt(1, fm.getFood_id());
            st.setString(2, fm.getFood_name());
            st.setDouble(3, fm.getFood_kcal());
            st.setDouble(4, fm.getFood_proteins());
            st.setDouble(5, fm.getFood_carbohydrates());
            st.setDouble(6, fm.getFood_fat());
            st.setInt(7, fm.getFood_id());
            st.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public FoodModel getFood(int id) {

        List<String> newFood = null;
        FoodModel model = new FoodModel();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM food WHERE food_id = " + id);
            newFood = new ArrayList();
            while (rs.next()) {
                int f1 = rs.getInt(1);
                String f2 = rs.getString(2);
                Double f3 = rs.getDouble(3);
                Double f4 = rs.getDouble(4);
                Double f5 = rs.getDouble(5);
                Double f6 = rs.getDouble(6);

                model.setFood_id(f1);
                model.setFood_name(f2);
                model.setFood_kcal(f3);
                model.setFood_proteins(f4);
                model.setFood_carbohydrates(f5);
                model.setFood_fat(f6);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return model;
    }

    @Override
    public List<FoodModel> getAllFood() {

        List<FoodModel> list = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM food");

            while (rs.next()) {
                FoodModel model = new FoodModel();
                int f1 = rs.getInt(1);
                String f2 = rs.getString(2);
                Double f3 = rs.getDouble(3);
                Double f4 = rs.getDouble(4);
                Double f5 = rs.getDouble(5);
                Double f6 = rs.getDouble(6);

                model.setFood_id(f1);
                model.setFood_name(f2);
                model.setFood_kcal(f3);
                model.setFood_proteins(f4);
                model.setFood_carbohydrates(f5);
                model.setFood_fat(f6);
                list.add(model);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

}
