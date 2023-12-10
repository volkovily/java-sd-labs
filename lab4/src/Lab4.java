import java.util.Arrays;
import java.util.Comparator;
/**
 * Class with executable method for sorting a furniture array.
 */
public class Lab4 {
    public static void main(String[] args) {
        Furniture[] furnitureArray = {
                new Furniture("Chair", 80, 50, 15.5, 59.99),
                new Furniture("Table", 75, 120, 50, 150.0),
                new Furniture("Sofa", 90, 180, 75.8, 300.0),
                new Furniture("Armchair", 90, 50, 20.3, 100.0),
                new Furniture("Bookshelf", 200, 80, 50, 100.0),
                new Furniture("Bed", 120, 160, 65, 400.0)
        };

        Arrays.sort(furnitureArray, Comparator.comparing(Furniture::getName));

        System.out.println("Sorting in ascending order based on the 'name':");
        for (Furniture furniture : furnitureArray) {
            System.out.println(furniture);
        }

        Arrays.sort(furnitureArray, Comparator.comparingDouble(Furniture::getPrice).reversed());

        System.out.println("\nSorting in descending order based on the 'price':");
        for (Furniture furniture : furnitureArray) {
            System.out.println(furniture);
        }
    }
}
