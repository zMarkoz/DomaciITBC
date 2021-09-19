package rs.itbootcamp.dao;

import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.MealModel;

import java.util.List;

public interface FoodDao {
    void insert(FoodModel fm);

    void delete(int id);

    void update(FoodModel fm);

    FoodModel getFood(int id);

    List<FoodModel> getAllFood();
    void addToFridge(int fridge_id, int food_id, double mass);

    public List<FoodModel> searchFood (String s);

}


