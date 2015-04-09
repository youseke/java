package ex08_01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {

    @Test
    public void perform() {
        int n1 = Integer.MAX_VALUE;
        int n2 = 100;
        int n3 = n1 + n2;
        assertNotEquals("2147483747", n3 + "");
        assertEquals(2147483747L, Integer.toUnsignedLong(n3));
        assertFalse(n3 > n2);
        assertTrue(Integer.compareUnsigned(n3, n2) > 0);
        int n4 = n3 / n2;
        assertNotEquals(21474837, n4);
        assertNotEquals(21474837, Integer.toUnsignedLong(n4));
        assertEquals(21474837, Integer.divideUnsigned(n3, n2));
    }
}
