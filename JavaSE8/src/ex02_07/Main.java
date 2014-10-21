package ex02_07;

import java.util.stream.Stream;

/**
 *
 * @author Tohtetsu Choh
 */
public class Main {

    public static void main(String[] args) {
    }

    public static <T> boolean isFinite(Stream<T> stream) {
        // There is no efficient way to decide whether a given stream is infinite or not since it's lazy. 
        return true;
    }
}
