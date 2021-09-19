package Main;


import rs.itbootcamp.dao.*;
import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.MealModel;
import rs.itbootcamp.model.UserModel;

import java.util.Scanner;

public class Test {
    private static MealModel newUserMeal() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Type in id: ");
        int id = sc.nextInt();
        System.out.println("Type name: ");
        String name = sc.next();
        System.out.println("Type description: ");
        String desc = sc.next();
        System.out.println("type level of difficulty: ");
        String difficulty = sc.next();
        return new MealModel(id, name, desc, difficulty);
    }

    private static FoodModel newUserFood() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Type in id: ");
        int id = sc.nextInt();
        System.out.println("Type name: ");
        String name = sc.next();
        System.out.println("Insert kcal: ");
        double kcal = sc.nextDouble();
        System.out.println("Insert proteins: ");
        double proteins = sc.nextDouble();
        System.out.println("Insert farbs: ");
        double carbs = sc.nextDouble();
        System.out.println("Insert fats: ");
        double fats = sc.nextDouble();
        return new FoodModel(id, name, kcal, proteins, carbs, fats);
    }

    private static UserModel newUser(){
        UserDaoSQL us = new UserDaoSQL();
        us.add(new UserModel(17, "Marko", "kodmarka@gmail.com", "java12345", true));
        us.getUser(17).setAdmin(false);
        us.update(new UserModel(17, "Marinko", "kodmarinka@burekmail.com", "java33333", false ));


        return null;
    }





    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FoodDao food = new FoodDaoSQL();
        MealDao meal = new MealDaoSQL();

        String menu = """
                0. Exit
                1. Add in Food
                2. See all the Foods
                3. Insert new Meals
                4. See all Meals
                5. 
                """;

        int choice = 5;
        while (choice != 0) {
            System.out.println(menu);
            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    food.insert(newUserFood());
                    break;
                case 2:
                    System.out.println(food.getAllFood());
                    break;
                case 3:
                    meal.insert(newUserMeal());
                case 4:
                    System.out.print(meal.getAllMeals());
            }
        }

    }
}