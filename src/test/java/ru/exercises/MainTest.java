package ru.exercises;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {
    @Test
    void sortMovesZerosBeforeOnes() {
        int[] numbers = {0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0};

        Main.sort(numbers);

        assertThat(numbers).containsExactly(0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1);
    }

    @Test
    void sortKeepsAlreadySortedArray() {
        int[] numbers = {0, 0, 1, 1};

        Main.sort(numbers);

        assertThat(numbers).containsExactly(0, 0, 1, 1);
    }

    @Test
    void sortHandlesEmptyArray() {
        int[] numbers = {};

        Main.sort(numbers);

        assertThat(numbers).isEmpty();
    }

    @Test
    void xorFindsSingleNumberWithoutPair() {
        assertThat(Main.xor(new int[]{3, 4, 0, 0, 2, 1, 4, 3, 1})).isEqualTo(2);
    }

    @Test
    void xorReturnsZeroForEmptyArray() {
        assertThat(Main.xor(new int[]{})).isZero();
    }
}
