package ru.exercises;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        runCaesarExercise();
        runSortExercise();
        runAnagramExercise();
        runXorExercise();
        runWalletExercise();
    }

    /* Реализовать шифрование методом Цезаря */
    private static void runCaesarExercise() {
        String message = "abc";
        int offset = 1;
        System.out.println("Source message: " + message + ", encrypted message: " + Caesar.encrypt(message, offset));
    }

    /*  Дан некоторый массив из 0 и 1, к примеру int[] numbers = [0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0],
        необходимо отсортировать массив максимально быстрым способом */
    private static void runSortExercise() {
        int[] numbersSort = {0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0};
        System.out.println("Array before sort: " + Arrays.toString(numbersSort));
        sort(numbersSort);
        System.out.println("Array after sort: " + Arrays.toString(numbersSort));
    }

    /* Дан массив строк, необходимо вывести все дубликаты, при этом дубликатом являются те строки, которые содержат
        одни и те же символы, но могут быть просто в другом порядке */
    private static void runAnagramExercise() {
        String[] words = new String[]{"самолет", "доска", "док", "летсамо", "скадо", "самокат"};
        AnagramDictionary dictionary = new AnagramDictionary(words);
        System.out.println(dictionary);

        Set<List<String>> set = new HashSet<>();
        for (String testWord : dictionary.getWords()) {
            List<String> anagrams = dictionary.getAnagrams(testWord);
            if (anagrams.size() > 1) {
                set.add(anagrams);
            }
        }
        System.out.println("Duplicates: " + set);
    }

    /* Известно, что числовой массив состоит из пар одинаковых чисел, но есть одно число в единственном экземпляре,
        необходимо найти это число за один проход по массиву */
    private static void runXorExercise() {
        int[] numbersWithUnique = {3, 4, 0, 0, 2, 1, 4, 3, 1};
        System.out.println("Array with unique: " + Arrays.toString(numbersWithUnique));
        System.out.println("Unique: " + xor(numbersWithUnique));
    }

    /* Вам даны несколько монет номиналом от 1 до 9 (монеты могут повторяться). Ваша функция должна вернуть
        минимальную положительную целую сумму, которую нельзя заплатить этими монетами без сдачи.
        Если, например, у Вас есть 2 монеты номиналом 3, 5, функция должна вернуть 1, т.к. если заплатим монетой 3,
        то сдача будет 2, а если 5 - сдача будет 4. Без сдачи нельзя.
        Если у Вас есть 3 монеты номиналом 1, 2, 3, функция должна вернуть 7, т.к. все числа, что меньше,
        можно оплатить этими монетами без сдачи */
    private static void runWalletExercise() {
        int[] coins = {1, 2, 3};
        Wallet wallet = new Wallet(coins);
        System.out.println(wallet);
        System.out.println("Minimum value without change: " + wallet.withoutChange());
    }

    public static void sort(int[] numbers) {
        int current = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1) continue;
            numbers[i] = 1;
            numbers[current] = 0;
            current++;
        }
    }

    public static int xor(int[] numbers) {
        int unique = 0;
        for (int i : numbers) {
            unique = unique ^ i;
        }
        return unique;
    }
}
