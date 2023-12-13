package component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a text made of a list of sentences.
 */
public class Text {
    private final StringBuffer text;

    /**
     * Constructs a Text from given StringBuffer.
     *
     * @param text The StringBuffer representing the text.
     */
    public Text(StringBuffer text) {
        this.text = cleanUpText(text);
    }
    
    /**
     * Replaces all tabs and multiple spaces with a single space.
     *
     * @param text The StringBuffer representing the text.
     * @return The cleaned-up StringBuffer.
     */
    private static StringBuffer cleanUpText(StringBuffer text) {
        return new StringBuffer(text.toString().replaceAll("[\\t\\s]+", " "));
    }

    /**
     * Gets the list of sentences in the text.
     *
     * @return The list of sentences.
     */
    public List<Sentence> getSentences() {
        List<Sentence> sentences = new ArrayList<>();
        Pattern sentencePattern = Pattern.compile("[^.!?]+[.!?]");
        Matcher sentenceMatcher = sentencePattern.matcher(text);

        while (sentenceMatcher.find()) {
            StringBuffer sentence = new StringBuffer(sentenceMatcher.group());
            sentences.add(Sentence.parseSentence(sentence));
        }

        return sentences;
    }

    /**
     * Overrides the toString method to return the text as string.
     *
     * @return The text as string.
     */
    @Override
    public String toString() {
        return text.toString();
    }
}