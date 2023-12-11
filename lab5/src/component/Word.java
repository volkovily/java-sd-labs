package component;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single word made of letters.
 */
public class Word {
    private final List<Letter> letters;

    /**
     * Constructs a Word with given list of letters.
     *
     * @param letters The list of letters in the word.
     */
    public Word(List<Letter> letters) {
        this.letters = letters;
    }

    /**
     * Gets the list of letters in the word.
     *
     * @return The list of letters.
     */
    public List<Letter> getLetters() {
        return letters;
    }

    /**
     * Gets the length of the word.
     *
     * @return The length of the word.
     */
    public int getLength() {
        return letters.size();
    }

    /**
     * Converts the word to a string.
     *
     * @param word The word to convert.
     * @return The lowercase string representation of the word.
     */
    public static String wordToString(Word word) {
        StringBuilder wordBuilder = new StringBuilder();
        for (Letter letter : word.getLetters()) {
            wordBuilder.append(Character.toLowerCase(letter.getValue()));
        }
        return wordBuilder.toString();
    }

    /**
     * Parses a word from the given string.
     *
     * @param wordString The string representing the word.
     * @return The list of letters parsed from the string.
     */
    public static List<Letter> parseWord(String wordString) {
        List<Letter> letters = new ArrayList<>();
        for (char c : wordString.toCharArray()) {
            letters.add(new Letter(c));
        }
        return letters;
    }
}
