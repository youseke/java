package ex01_09;

import java.util.Arrays;

/**
 *
 * @author Tohtetsu Choh
 */
public class TestCollection2 {
    
    public static void main(String[] args) {
        Collection2<Integer> numbers = Arrays.asList(10, 25, 5, 100, 0, 20, 8);
        numbers.forEachIf(p -> System.out.println(p), p -> p > 10);
    }
}
