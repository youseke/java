package ex03_07;

import java.util.Comparator;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {

    public static Comparator<String> stringComparator(Comparator<String> comparator1, Comparator<String> comparator2) {
        return (s1, s2) -> {
            int resultComparator1 = comparator1.compare(s1, s2);
            if (resultComparator1 == 0) {
                return comparator2.compare(s1, s2);
            } else {
                return resultComparator1;
            }
        };
    }
}
