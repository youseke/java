package ex03_16;

import ex03.CommonUtil;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import org.junit.Test;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass implements CommonUtil {

    @Override
    @Test
    public void perform() {
        this.doInOrderAsync(
                () -> Integer.parseInt("a"),
                (i, e) -> {
                    if (i != null) {
                        System.out.printf("Parsed int: %d", i);
                    } else {
                        if (e instanceof NumberFormatException) {
                            System.out.printf("Couldn't parse, using defaults");
                        } else {
                            System.out.println("Something bad happened");
                        }
                    }
                }
        );
    }

    public static <T> void doInOrderAsync(Supplier<T> first, BiConsumer<T, Throwable> second) {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    T result = first.get();
                    second.accept(result, null);
                } catch (Throwable t) {
                    second.accept(null, t);
                }
            }
        };
        t.start();
    }
}
