package ex03_16;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {

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
