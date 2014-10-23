package ex02_08;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Tohtetsu Choh
 */
public class Main {

    public static void main(String[] args) {
        Stream<String> f1 = Stream.of("1", "2", "3", "4");
        Stream<String> f2 = Stream.of("1");
        System.out.println(Arrays.toString(zip(f1, f2).toArray()));
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> f = first.collect(Collectors.toList());
        List<T> s = second.collect(Collectors.toList());
        if (f.size() >= s.size()) {
            return Stream.concat(f.stream().limit(s.size()), s.stream());
        } else
            return Stream.concat(f.stream(), s.stream().limit(f.size()));
    }
}
