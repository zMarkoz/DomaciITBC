package rs.itbootcamp.dao;

import rs.itbootcamp.model.FoodModel;

import java.util.List;

public interface FoodDao {
    void insert(FoodModel fm);

    void delete(int id);

    void update(FoodModel fm);

    FoodModel getFood(int id);

    List<FoodModel> getAllFood();

}


