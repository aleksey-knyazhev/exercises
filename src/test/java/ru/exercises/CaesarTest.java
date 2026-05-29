package ru.exercises;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CaesarTest {
    @Test
    void encryptShiftsCharactersByOffset() {
        assertThat(Caesar.encrypt("abc", 1)).isEqualTo("bcd");
    }

    @Test
    void encryptSupportsNegativeOffset() {
        assertThat(Caesar.encrypt("bcd", -1)).isEqualTo("abc");
    }

    @Test
    void encryptReturnsEmptyStringForEmptyMessage() {
        assertThat(Caesar.encrypt("", 3)).isEmpty();
    }
}
