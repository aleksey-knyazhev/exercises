package ru.exercises;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WalletTest {
    @Test
    void withoutChangeReturnsOneWhenSmallestCoinIsGreaterThanOne() {
        Wallet wallet = new Wallet(new int[]{3, 5});

        assertThat(wallet.withoutChange()).isEqualTo(1);
    }

    @Test
    void withoutChangeReturnsNextValueAfterAllValuesCanBePaid() {
        Wallet wallet = new Wallet(new int[]{1, 2, 3});

        assertThat(wallet.withoutChange()).isEqualTo(7);
    }

    @Test
    void withoutChangeHandlesRepeatedCoins() {
        Wallet wallet = new Wallet(new int[]{1, 1, 3, 4});

        assertThat(wallet.withoutChange()).isEqualTo(10);
    }

    @Test
    void withoutChangeReturnsOneForEmptyWallet() {
        Wallet wallet = new Wallet(new int[]{});

        assertThat(wallet.withoutChange()).isEqualTo(1);
    }
}
