import list.VegetableList;
import vegetable.Vegetable;

import java.util.Comparator;

/**
 * Class representing a salad composed of vegetables.
 */
public class Salad {
    private final VegetableList<Vegetable> vegetables = new VegetableList<>();

    /**
     * Adds a vegetable to the salad.
     * @param vegetable The vegetable to add to salad.
     */
    public void addVegetable(Vegetable vegetable) {
        vegetables.add(vegetable);
    }

    /**
     * Calculates the total calories in the salad.
     * @return The total calories in the salad.
     */
    public int countCalories() {
        int totalCalories = 0;
        for (Vegetable vegetable : vegetables) {
            totalCalories += vegetable.getCalories();
        }
        return totalCalories;
    }

    /**
     * Sorts the vegetables in the salad by calories.
     */
    public void sortVegetablesByCalories() {
        vegetables.sort(Comparator.comparingInt(Vegetable::getCalories));
    }

    /**
     * Finds vegetables in the salad within a specified range of calories.
     * @param min The minimum calories for the range.
     * @param max The maximum calories for the range.
     * @return A list of vegetables within the specified range.
     */
    public VegetableList<Vegetable> findVegetablesByCaloriesRange(int min, int max) {
        VegetableList<Vegetable> result = new VegetableList<>();
        for (Vegetable vegetable : vegetables) {
            if (vegetable.getCalories() >= min && vegetable.getCalories() <= max) {
                result.add(vegetable);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Salad: " + vegetables;
    }
}
