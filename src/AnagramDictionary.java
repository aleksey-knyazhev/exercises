import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AnagramDictionary {
    private final String[] words;
    private final String[] normalizedWords;

    public AnagramDictionary(String[] words) {
        this.words = words;
        this.normalizedWords = Arrays.stream(words).map(this::normalize).distinct().toArray(String[]::new);
    }

    public String[] getWords() {
        return words;
    }

    private String normalize(String word) {
        return word.chars()        // IntStream
                .sorted()
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }

    public List<String> getAnagrams(String testWord) {
        ArrayList<String> result = new ArrayList<>();
        if (testWord == null || testWord.equals("")) {
            return result;
        }

        String normalizedTestWord = normalize(testWord);
        if (Arrays.asList(normalizedWords).contains(normalizedTestWord)) {
            for (String word : words) {
                if (normalizedTestWord.equals(normalize(word))) {
                    result.add(word);
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "AnagramDictionary{" +
                "words=" + Arrays.toString(words) +
                ", normalizedWords=" + Arrays.toString(normalizedWords) +
                '}';
    }
}
