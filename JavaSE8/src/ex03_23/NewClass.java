package ex03_23;

import java.util.function.Function;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {

    public static class Pair<T> {

        public T obj1;
        public T obj2;

        public Pair(T obj1, T obj2) {
            this.obj1 = obj1;
            this.obj2 = obj2;
        }
    }

    public static <T, U> Pair<U> map(Pair<T> pair, Function<T, U> function) {
        return new Pair<>(function.apply(pair.obj1), function.apply(pair.obj2));
    }
}
