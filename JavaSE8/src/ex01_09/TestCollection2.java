package ex01_09;

/**
 *
 * @author Tohtetsu Choh
 */
public class TestCollection2 {

    public static void main(String[] args) {
        Collection2<Integer> numbers = null;
        numbers.forEachIf(p -> System.out.println(p), p -> p > 10);
    }
}
