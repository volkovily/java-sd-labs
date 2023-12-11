package component;

/**
 * Represents a punctuation character.
 */
class Punctuation {
    private final char value;

    /**
     * Constructs a Punctuation with given character value.
     *
     * @param value The character value of punctuation.
     */
    public Punctuation(char value) {
        this.value = value;
    }

    /**
     * Gets the character value of the punctuation.
     *
     * @return The character value.
     */
    public char getValue() {
        return value;
    }
}
