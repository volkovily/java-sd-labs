package component;

/**
 * Represents a single letter.
 */
public class Letter {
    private final char value;

    /**
     * Constructs a Letter with given character value.
     *
     * @param value The character value of the letter.
     */
    public Letter(char value) {
        this.value = value;
    }

    /**
     * Gets the character value of the letter.
     *
     * @return The character value.
     */
    public char getValue() {
        return value;
    }
}
