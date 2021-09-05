package NutriApp;

import java.util.ArrayList;
import java.util.List;

public class Meals {
    List<Meal> meals;

    public Meals() {
        this.meals = new ArrayList<>();

    }

    public void add(Meal m) {
        if (!meals.contains(m)) {
            meals.add(m);
        }
    }

    public void remove(Meal m) {
        for (Meal b : meals) {
            if (b.equals(m)) {
                meals.remove(b);
                break;
            }
        }
    }

    public List<Meal> search(String s) {
        List<Meal> mealList = new ArrayList<>();
        for (Meal b : meals) {
            if (b.name.contains(s)) {
                mealList.add(b);
            }
        }
        return mealList;
    }

    public List<Meal> search(List<Nutriment> nutriments) {
        List<Meal> mealList = new ArrayList<>();
        for (Meal b : meals) {
            if (b.nutriments.equals(nutriments)) {
                mealList.add(b);
            }
        }
        return mealList;
    }

    public List<Meal> search(double kcal) {
        List<Meal> mealList = new ArrayList<>();
        for (Meal b : meals) {
            if (b.getKcal() < kcal) {
                mealList.add(b);
            }
        }
        return mealList;
    }

    @Override
    public String toString() {
        String s = "";
        for (Meal el : meals) {
            s += el.id + " Name: " + el.name + "\n";
        }
        return s;
    }
}
