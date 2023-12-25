package vegetable;

/**
 * Class representing a vegetable.
 */
public class Vegetable {
    private final String name;
    private final int calories;

    /**
     * Constructs a vegetable with the specified name and calories.
     * @param name The name of the vegetable.
     * @param calories The calories of the vegetable.
     */
    public Vegetable(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    /**
     * Gets the name of the vegetable.
     * @return The name of the vegetable.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the calories of the vegetable.
     * @return The calories of the vegetable.
     */
    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return name + " - " + calories + " calories";
    }
}
