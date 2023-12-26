package test;

import list.VegetableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import salad.Salad;
import vegetable.Carrot;
import vegetable.Cucumber;
import vegetable.Tomato;
import vegetable.Vegetable;


import static org.junit.jupiter.api.Assertions.*;

public class SaladTest {
    private Salad salad;
    private Vegetable tomato;
    private Vegetable cucumber;
    private Vegetable carrot;

    @BeforeEach
    void setUp() {
        salad = new Salad();
        tomato = new Tomato("Tomato", 20);
        cucumber = new Cucumber("Cucumber", 15);
        carrot = new Carrot("Carrot", 30);
    }

    @Test
    void testAddVegetable() {
        salad.addVegetable(tomato);
        salad.addVegetable(cucumber);

        assertEquals("Salad: Tomato - 20 calories, Cucumber - 15 calories", salad.toString());
    }

    @Test
    void testCountCalories() {
        salad.addVegetable(tomato);
        salad.addVegetable(cucumber);
        salad.addVegetable(carrot);

        assertEquals(65, salad.countCalories());
    }

    @Test
    void testSortVegetablesByCalories() {
        salad.addVegetable(tomato);
        salad.addVegetable(cucumber);
        salad.addVegetable(carrot);

        salad.sortVegetablesByCalories();

        assertEquals("Salad: Cucumber - 15 calories, Tomato - 20 calories, Carrot - 30 calories", salad.toString());
    }

    @Test
    void testFindVegetablesByCaloriesRange() {
        salad.addVegetable(tomato);
        salad.addVegetable(cucumber);
        salad.addVegetable(carrot);

        VegetableList<Vegetable> result = salad.findVegetablesByCaloriesRange(15, 25);

        assertEquals("Tomato - 20 calories, Cucumber - 15 calories", result.toString());
    }
}
