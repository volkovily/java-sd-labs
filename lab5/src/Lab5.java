import component.Sentence;
import component.Text;
import component.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Class contains the main method to execute the program, along with utility methods for text.
 */
public class Lab5 {
    public static void main(String[] args) {
        try {
            Text text = new Text(new StringBuffer("This      a is test test message? Yes, with some test words. TESt, are you sure?"));
            int wordLength = 4;

            validateText(text);

            System.out.println(text + "\n");
            findWordsInQuestions(text, wordLength);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Validates that the provided text is not null or empty.
     *
     * @param text The Text object to validate.
     * @throws Exception If the text is null or empty.
     */
    private static void validateText(Text text) throws Exception {
        if (text == null || text.toString().isEmpty()) {
            throw new Exception("Text is empty or null.");
        }
    }

    /**
     * Finds and prints words of a specified length in question sentences.
     *
     * @param text       The Text object containing sentences.
     * @param wordLength The length of words to find.
     */
    private static void findWordsInQuestions(Text text, int wordLength) {
        List<Word> words = new ArrayList<>();

        for (Sentence sentence : text.getSentences()) {
            for (Object element : sentence.getElements()) {
                if (element instanceof Word word) {
                    if (word.getLength() == wordLength && !contains(words, word)) {
                        words.add(word);
                    }
                }
            }
        }

        System.out.println("Words with length " + wordLength + " in question sentences:");
        for (Word word : words) {
            System.out.println(Word.wordToString(word));
        }
    }

    /**
     * Checks if the list contains a word.
     *
     * @param list The list of words.
     * @param word The word to check.
     * @return True if the list contains the word, false otherwise.
     */
    private static boolean contains(List<Word> list, Word word) {
        for (Word w : list) {
            if (Word.wordToString(w).equals(Word.wordToString(word))) {
                return true;
            }
        }
        return false;
    }
}
