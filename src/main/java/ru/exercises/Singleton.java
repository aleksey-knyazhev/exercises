package ru.exercises;

import java.io.Serial;
import java.io.Serializable;

public class Singleton implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    @Serial
    private Object readResolve() {
        return getInstance();
    }

    public void printMessage() {
        System.out.println("Business logic from Singleton");
    }
}
