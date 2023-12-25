import vegetable.Carrot;
import vegetable.Cucumber;
import vegetable.Tomato;
import vegetable.Vegetable;

import java.util.ArrayList;

/**
 * Class with executable method for operations with salad.
 */
public class Lab6 {
    // C13=3
    public static void main(String[] args) {
        Tomato tomato = new Tomato();
        Cucumber cucumber = new Cucumber();
        Carrot carrot = new Carrot();

        Salad salad = new Salad();
        salad.addVegetable(tomato);
        salad.addVegetable(cucumber);
        salad.addVegetable(carrot);
        System.out.println(salad);

        int totalCalories = salad.countCalories();
        System.out.println("Total calories of the salad: " + totalCalories);

        salad.sortVegetablesByCalories();
        System.out.println("Sorted vegetables by calories: " + salad);

        int min = 15;
        int max = 25;
        ArrayList<Vegetable> vegetablesInRange = salad.findVegetablesByCaloriesRange(min, max);
        System.out.println("Vegetables in the range " + min + " - " + max + " calories: " + vegetablesInRange);
    }
}
