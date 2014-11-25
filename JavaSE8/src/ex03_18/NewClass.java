package ex03_18;

import java.util.function.Function;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {

    public static <T, U> Function<T, U> unchecked(BiCallable<T, U> f) {
        return (T arg) -> {
            try {
                return f.call(arg);
            } catch (Exception e) {
                throw new RuntimeException(e);
            } catch (Throwable t) {
                throw t;
            }
        };
    }
}
