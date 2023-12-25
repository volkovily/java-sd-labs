import list.VegetableList;
import vegetable.Carrot;
import vegetable.Cucumber;
import vegetable.Tomato;
import vegetable.Vegetable;

/**
 * Class with executable method for operations with salad.
 */
public class Lab7 {
    // C13=3 C2=0 C3=1
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
        VegetableList<Vegetable> vegetablesInRange = salad.findVegetablesByCaloriesRange(min, max);
        System.out.println("Vegetables in the range " + min + " - " + max + " calories: " + vegetablesInRange);
    }
}
