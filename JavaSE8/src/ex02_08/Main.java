package ex02_08;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author Tohtetsu Choh
 */
public class Main {

    public static void main(String[] args) {
        Stream<String> f1= Stream.of("1", "2", "3", "4");
        Stream<String> f2= Stream.of("1");
        System.out.println(zip(f1, f2).toString());
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        while (first.findAny().isPresent()) {
            if (second.findAny().isPresent()) {
                second = second.skip(1);
            } else {
                return first;
            }
            first = first.skip(1);
        }
        return second;
    }
}
