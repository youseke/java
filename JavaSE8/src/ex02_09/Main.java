package ex02_09;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 *
 * @author Tohtetsu Choh
 */
public class Main {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> combine01(Stream<ArrayList<T>> stream) {
        return stream.reduce(new ArrayList(), (i, s) -> {
            i.addAll(s);
            return i;
        });
    }

    public static <T> ArrayList<T> combine02(Stream<ArrayList<T>> stream) {
        return stream.reduce((i, s) -> {
            i.addAll(s);
            return i;
        }).get();
    }

    public static <T> ArrayList<T> combine03(Stream<ArrayList<T>> stream) {
        return stream.reduce(new ArrayList<T>(), (i, s) -> {
            i.addAll(s);
            return i;
        }, (i, s) -> {
            i.addAll(s);
            return i;
        });
    }

}
