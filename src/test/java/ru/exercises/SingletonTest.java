package ru.exercises;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

class SingletonTest {
    @Test
    void getInstanceReturnsSameObject() {
        Singleton first = Singleton.getInstance();
        Singleton second = Singleton.getInstance();

        assertThat(first).isSameAs(second);
    }

    @Test
    void printMessagePrintsBusinessLogicMessage() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));

            Singleton.getInstance().printMessage();

            assertThat(output.toString(StandardCharsets.UTF_8))
                    .isEqualTo("Business logic from Singleton" + System.lineSeparator());
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void deserializationReturnsSameObject() throws Exception {
        Singleton singleton = Singleton.getInstance();
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();

        try (ObjectOutputStream output = new ObjectOutputStream(bytes)) {
            output.writeObject(singleton);
        }

        Object deserialized;
        try (ObjectInputStream input = new ObjectInputStream(new java.io.ByteArrayInputStream(bytes.toByteArray()))) {
            deserialized = input.readObject();
        }

        assertThat(deserialized).isSameAs(singleton);
    }
}
