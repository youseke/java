package ex03_24;

import ex03.CommonUtil;
import java.util.function.BiFunction;
import java.util.function.Function;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass implements CommonUtil {

    private class Pair<T> {

        T one;
        T two;

        private Pair(T one, T two) {
            this.one = one;
            this.two = two;
        }

        <U> Pair<U> flatMap(BiFunction<? super T, ? super T, Pair<U>> mapper) {
            return mapper.apply(one, two);
        }
    }

    @Test
    @Override
    public void perform() {
        Pair<String> strPair = new Pair<>("1", "2");
        Pair<Integer> intPair = strPair.flatMap((a, b) -> new Pair<>(Integer.parseInt(a), Integer.parseInt(b)));
        assertEquals(new Integer(1), intPair.one);
        assertEquals(new Integer(2), intPair.two);
    }
}
