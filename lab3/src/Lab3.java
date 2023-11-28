import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab3 {

    public static void main(String[] args) {
        try {
            StringBuffer text = new StringBuffer("This a is test test message? Yes, with some test words. Are you sure?");
            int wordLength = 4;

            validateText(text);

            System.out.println(text + "\n");
            findWordsInQuestions(text, wordLength);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void validateText(StringBuffer text) throws Exception {
        if (text == null || text.isEmpty()) {
            throw new Exception("Text is empty or null.");
        }
    }

    private static void findWordsInQuestions(StringBuffer text, int wordLength) {
        List<StringBuffer> questionSentences = getQuestionSentences(text);
        List<StringBuffer> words = new ArrayList<>();

        for (StringBuffer sentence : questionSentences) {
            List<StringBuffer> sentenceWords = getWords(sentence);

            for (StringBuffer word : sentenceWords) {
                if (word.length() == wordLength && !contains(words, word)) {
                    words.add(word);
                }
            }
        }

        System.out.println("Words with length " + wordLength + " in question sentences:");
        for (StringBuffer word : words) {
            System.out.println(word);
        }
    }

    private static boolean contains(List<StringBuffer> list, StringBuffer word) {
        for (StringBuffer sb : list) {
            if (sb.toString().contentEquals(word)) {
                return true;
            }
        }
        return false;
    }

    private static List<StringBuffer> getQuestionSentences(StringBuffer text) {
        List<StringBuffer> questionSentences = new ArrayList<>();
        Pattern pattern = Pattern.compile("[^.!?]+[?]");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            questionSentences.add(new StringBuffer(matcher.group()));
        }

        return questionSentences;
    }

    private static List<StringBuffer> getWords(StringBuffer sentence) {
        List<StringBuffer> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(sentence);

        while (matcher.find()) {
            words.add(new StringBuffer(matcher.group()));
        }

        return words;
    }
}