package ex02_10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author Tohtetsu Choh
 */
public class Main {

    public static void main(String[] args) {
        List<Double> dList = Arrays.asList(0.0, 0.1, 0.2);
        System.out.println(sum(dList.stream()));
    }

    public static Double sum(Stream<Double> stream) {
        return stream.reduce(0.0, (i, s) -> {
            i += s;
            return i;
        });
    }
}
