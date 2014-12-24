package ex03_01;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {

    public static void main(String... args) {
        System.out.println("Test logging.");
        logIf(Level.INFO, () -> true, () -> "Log Test");
    }

    public static void logIf(Level level, Supplier<Boolean> condition, Supplier<String> message) {
        Logger logger = Logger.getGlobal();
        if (logger.isLoggable(level) && condition.get()) {
            logger.log(level, message.get());
        }
    }
}
