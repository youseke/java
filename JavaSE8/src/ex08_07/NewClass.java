package ex08_07;

import java.util.Arrays;
import static java.util.Comparator.nullsLast;
import static java.util.Comparator.reverseOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {

    @Test
    public void perform() {
        String[] words = {
            "bbb",
            "aaa",
            null,
            "ccc"
        };
        Arrays.sort(words, nullsLast(reverseOrder()));
        assertEquals("ccc", words[0]);
        assertEquals("bbb", words[1]);
        assertEquals("aaa", words[2]);
        assertNull(words[3]);
    }
}
