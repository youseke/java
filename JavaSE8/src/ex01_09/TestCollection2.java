package ex01_09;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Tohtetsu Choh
 */
public class TestCollection2 {
    public static void main(String[] args){
        Collection2<Integer> numbers = null;
       numbers.forEachIf(p -> System.out.println(p), p -> p>10 );
    }
}
