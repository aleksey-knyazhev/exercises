package ru.exercises;

import java.util.Arrays;
import java.util.Collections;

class Wallet {
    private final int[] coins;
    private int total;

    public Wallet(int[] coins) {
        this.coins = Arrays.stream(coins).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        this.total = Arrays.stream(coins).sum();
    }

    public int withoutChange() {
        for (int i = 1; i <= total + 1; i++) {
            //System.out.println("i: " + i);
            if (check(i)) {
                return i;
            }
        }
        return 0;
    }

    private boolean check(int left) {
        for (int coin : coins) {
            if (coin > left) continue;
            if (coin == left) return false;

            left -= coin;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "coins=" + Arrays.toString(coins) +
                ", total=" + total +
                '}';
    }
}
