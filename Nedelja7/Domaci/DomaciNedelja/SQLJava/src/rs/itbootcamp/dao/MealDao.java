package rs.itbootcamp.dao;

import rs.itbootcamp.model.MealModel;
import rs.itbootcamp.model.FoodModel;

import java.util.List;

public interface MealDao {
    void insert(MealModel mm);

    void delete(int id);

    void update(MealModel mm);

    MealModel getMeal(int id);

    List<MealModel> getAllMeals();

    List<String> getFoodMealNames(int meal_id);

    List<FoodModel> getFoodMeal(int meal_id);//sva hrana za jelo sa id = mm

    void addToFridge(int fridge_id, int food_id, double mass);

    public List<MealModel> searchMeal (String s);
}

