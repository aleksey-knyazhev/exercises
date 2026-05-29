package ru.exercises;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EnumSingletonTest {
    @Test
    void instanceReturnsSameObject() {
        EnumSingleton first = EnumSingleton.INSTANCE;
        EnumSingleton second = EnumSingleton.INSTANCE;

        assertThat(first).isSameAs(second);
    }

    @Test
    void printMessagePrintsBusinessLogicMessage() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));

            EnumSingleton.INSTANCE.printMessage();

            assertThat(output.toString(StandardCharsets.UTF_8))
                    .isEqualTo("Business logic from Singleton" + System.lineSeparator());
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void deserializationReturnsSameObject() throws Exception {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();

        try (ObjectOutputStream output = new ObjectOutputStream(bytes)) {
            output.writeObject(EnumSingleton.INSTANCE);
        }

        Object deserialized;
        try (ObjectInputStream input = new ObjectInputStream(new java.io.ByteArrayInputStream(bytes.toByteArray()))) {
            deserialized = input.readObject();
        }

        assertThat(deserialized).isSameAs(EnumSingleton.INSTANCE);
    }

    @Test
    void reflectionCannotCreateNewInstance() throws Exception {
        Constructor<EnumSingleton> constructor = EnumSingleton.class
                .getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);

        assertThatThrownBy(() -> constructor.newInstance("OTHER", 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Cannot reflectively create enum objects");
    }
}
