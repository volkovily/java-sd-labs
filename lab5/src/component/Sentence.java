package component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a sentence made of a list of words and punctuation.
 */
public class Sentence {
    private final List<Object> elements;

    /**
     * Constructs a Sentence with given list of elements.
     *
     * @param elements The list of elements that form the sentence.
     */
    public Sentence(List<Object> elements) {
        this.elements = elements;
    }

    /**
     * Gets the list of elements in the sentence.
     *
     * @return The list of elements.
     */
    public List<Object> getElements() {
        return elements;
    }

    /**
     * Parses a sentence from the given StringBuffer.
     *
     * @param sentence The StringBuffer representing the sentence.
     * @return The parsed Sentence object.
     */
    public static Sentence parseSentence(StringBuffer sentence) {
        List<Object> elements = new ArrayList<>();
        Pattern wordPattern = Pattern.compile("[a-zA-Z]+");
        Matcher wordMatcher = wordPattern.matcher(sentence);
        Matcher punctuationMatcher = Pattern.compile("[.,:;?!]+").matcher(sentence);

        while (wordMatcher.find()) {
            elements.add(new Word(Word.parseWord(wordMatcher.group())));
        }

        while (punctuationMatcher.find()) {
            char punctuation = punctuationMatcher.group().charAt(0);
            elements.add(new Punctuation(punctuation));
        }

        return new Sentence(elements);
    }

    public boolean isQuestion(Sentence sentence) {
        for (Object element : sentence.getElements()) {
            if (element instanceof Punctuation punctuation && punctuation.getValue() == '?') {
                return true;
            }
        }
        return false;
    }
}
