/**
 * Class that represents some furniture.
 */
class Furniture {
    private final String name;
    private final int height;
    private final int width;
    private final double weight;
    private final double price;

    /**
     * Constructor for the Furniture class.
     *
     * @param name     The name of the furniture.
     * @param height   The height of the furniture.
     * @param width    The width of the furniture.
     * @param weight   The weight of the furniture.
     * @param price    The price of the furniture.
     */
    public Furniture(String name, int height, int width, double weight, double price) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.weight = weight;
        this.price = price;
    }

    // Getters
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    /**
     * Method to represent the Furniture object as a string.
     *
     * @return String representation of the object.
     */
    @Override
    public String toString() {
        return String.format("Furniture{name='%s'; height=%d; width=%d; weight=%.2f; price=%.2f}",
                name, height, width, weight, price);
    }
}
