package ex03_07;

import static ex03_07.CompareOptions.*;
import ex03_22.Exercise;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumSet;

import static org.junit.Assert.assertArrayEquals;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass implements Exercise {

    @Test
    @Override
    public void perform() {
        String[] values = {
            "BBB",
            " ccc",
            "aaa"
        };
        Arrays.sort(values, comparatorGenerator(EnumSet.of(
                REVERSE,
                CASE_INSENSITIVE,
                SPACE_INSENSITIVE
        )));
        assertArrayEquals(values, new String[]{
            " ccc",
            "BBB",
            "aaa"
        });
        Arrays.sort(values, comparatorGenerator(EnumSet.noneOf(CompareOptions.class)));
        assertArrayEquals(values, new String[]{
            " ccc",
            "BBB",
            "aaa"
        });
    }

    public Comparator<String> comparatorGenerator(EnumSet<CompareOptions> options) {
        return (x, y) -> {
            if (options.contains(CASE_INSENSITIVE)) {
                x = x.toLowerCase();
                y = y.toLowerCase();
            }
            if (options.contains(SPACE_INSENSITIVE)) {
                x = x.replaceAll("\\s+", "");
                y = y.replaceAll("\\s+", "");
            }
            return options.contains(REVERSE) ? y.compareTo(x) : x.compareTo(y);
        };
    }

}
