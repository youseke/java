package ex08_02;

import org.junit.Test;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {

    @Test(expected = Exception.class)
    public void perform() {
        java.lang.Math.negateExact(Integer.MIN_VALUE);
    }
}
