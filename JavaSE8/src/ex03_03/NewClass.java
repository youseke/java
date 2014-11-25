package ex03_03;

import java.util.function.Supplier;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {

    public static void assertMethod(Supplier<Boolean> condition) {
        if (!condition.get()) {
            throw new AssertionError();
        }
    }

    public static void main(String... args) {
        System.out.println("Exercise 3");
        assertMethod(() -> Math.random() < 0.5);
    }
}
