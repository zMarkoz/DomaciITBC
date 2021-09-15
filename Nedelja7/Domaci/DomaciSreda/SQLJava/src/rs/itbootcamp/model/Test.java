package rs.itbootcamp.model;


import rs.itbootcamp.dao.FoodDao;
import rs.itbootcamp.dao.FoodDaoSQL;
import rs.itbootcamp.dao.MealDao;
import rs.itbootcamp.dao.MealDaoSQL;

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FoodDao fd = new FoodDaoSQL();
        MealDao md = new MealDaoSQL();

        String menu = """
                0. Exit
                1. Add in Food
                2. See all the Foods
                3. Insert new Meals
                4. See all Meals
                """;

        int choice = 5;
        while (choice != 0) {
            System.out.println(menu);
            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    fd.insert(newUserFood());
                    break;
                case 2:
                    System.out.println(fd.getAllFood());
                    break;
                case 3:
                    md.insert(newUserMeal());
                case 4:
                    System.out.print(md.getAllMeals());

            }
        }

    }
}