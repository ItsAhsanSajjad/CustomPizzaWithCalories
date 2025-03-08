package pzinsta.pizzeria.model.pizza;

import java.util.HashMap;
import java.util.Map;

public class IngredientCalorieData {
    private static final Map<String, Integer> calorieData = new HashMap<>();

    static {
        calorieData.put("Anchovies", 50);
        calorieData.put("Sausage", 150);
        calorieData.put("Pepperoni", 100);
        calorieData.put("Chicken", 120);
        calorieData.put("Meatballs", 200);
        calorieData.put("Ham", 80);
        calorieData.put("Steak", 250);
        calorieData.put("Bacon", 180);
        calorieData.put("Beef", 200);
        calorieData.put("Salami", 110);
        calorieData.put("Spinach", 10);
        calorieData.put("Mushrooms", 15);
        calorieData.put("Red Onion", 20);
        calorieData.put("Onion", 20);
        calorieData.put("Banana Peppers", 5);
        calorieData.put("Pineapple", 50);
        calorieData.put("Jalapeno", 10);
        calorieData.put("Black Olive", 25);
        calorieData.put("Green Pepper", 15);
        calorieData.put("Tomatoes", 20);
        calorieData.put("White Sauce", 50);
        calorieData.put("Classic Red", 40);
        calorieData.put("Sweet Red", 45);
        calorieData.put("Spicy Red", 50);
        calorieData.put("Roasted Garlic", 30);
        calorieData.put("Feta Cheese", 70);
        calorieData.put("Cheddar Cheese", 110);
        calorieData.put("Shaved Parmesan", 90);
        calorieData.put("Parmesan", 90);
        calorieData.put("Mozzarella", 80);
        calorieData.put("Taco", 60);
        calorieData.put("Buffalo", 70);
        calorieData.put("Pesto", 80);
        calorieData.put("BBQ", 75);
        calorieData.put("Goat", 100);
        calorieData.put("Ricotta", 60);
        calorieData.put("Blue", 100);
        calorieData.put("Artichoke", 40);
        calorieData.put("Basil", 5);
    }

    public static int getCalories(String ingredientName) {
        return calorieData.getOrDefault(ingredientName, 0);
    }
}