package ex03_23;

import ex03.CommonUtil;
import java.util.function.Function;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass implements CommonUtil {

    @Test
    @Override
    public void perform() {
        Pair<String> strPair = new Pair<>("1", "2");
        Pair<Integer> intPair = strPair.map(Integer::parseInt);
        assertEquals(new Integer(1), intPair.one);
        assertEquals(new Integer(2), intPair.two);
    }

    private class Pair<T> {

        T one;
        T two;

        private Pair(T one, T two) {
            this.one = one;
            this.two = two;
        }

        <U> Pair<U> map(Function<? super T, ? extends U> mapper) {
            return new Pair<>(mapper.apply(one), mapper.apply(two));
        }
    }
}
