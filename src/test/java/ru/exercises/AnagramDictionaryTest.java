package ru.exercises;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AnagramDictionaryTest {
    @Test
    void getWordsReturnsOriginalWords() {
        String[] words = {"air", "ria", "cat"};
        AnagramDictionary dictionary = new AnagramDictionary(words);

        assertThat(dictionary.getWords()).containsExactly("air", "ria", "cat");
    }

    @Test
    void getAnagramsReturnsWordsWithSameCharacters() {
        AnagramDictionary dictionary = new AnagramDictionary(new String[]{"listen", "silent", "enlist", "stone"});

        assertThat(dictionary.getAnagrams("listen")).containsExactly("listen", "silent", "enlist");
    }

    @Test
    void getAnagramsReturnsEmptyListForUnknownWord() {
        AnagramDictionary dictionary = new AnagramDictionary(new String[]{"listen", "silent"});

        assertThat(dictionary.getAnagrams("stone")).isEmpty();
    }

    @Test
    void getAnagramsReturnsEmptyListForNullAndEmptyWord() {
        AnagramDictionary dictionary = new AnagramDictionary(new String[]{"listen", "silent"});

        assertThat(dictionary.getAnagrams(null)).isEmpty();
        assertThat(dictionary.getAnagrams("")).isEmpty();
    }
}
