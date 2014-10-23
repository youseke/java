package ex02_11;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Tohtetsu Choh
 */
public class Main {

    public static void main(String[] args) {
        Stream<String> s = Stream.of("1", "2", "3", "4", "5");
        List l = s.parallel().collect(Collectors.toList());
        System.out.println(l);
    }
}
