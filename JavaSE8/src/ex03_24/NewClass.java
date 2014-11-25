package ex03_24;

import ex03_23.NewClass.Pair;
import java.util.function.Function;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {

    public static <T, U> U flatMap(Pair<T> pair, Function<Pair<T>, U> function) {
        return function.apply(pair);
    }
}
