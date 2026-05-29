package ru.exercises;

public enum EnumSingleton {
    INSTANCE;

    public void printMessage() {
        System.out.println("Business logic from Singleton");
    }
}
