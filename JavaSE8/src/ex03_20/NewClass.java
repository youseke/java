package ex03_20;

import ex03.CommonUtil;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass implements CommonUtil {

    @Test
    @Override
    public void perform() {
        List<Integer> ints = map(Arrays.asList("1", "2", "3"), Integer::parseInt);
        assertTrue(ints.size() == 3);
    }

    public static <T, U> List<U> map(List<T> list, Function<T, U> function) {
        return list.stream().map(function).collect(Collectors.toList());
    }
}
