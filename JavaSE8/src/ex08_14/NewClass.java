package ex08_14;

import java.time.LocalDateTime;
import java.util.Objects;
import org.junit.Test;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {

    @Test(expected = NullPointerException.class)
    public void perform() {
        test(null);
    }

    public void test(String a) {
        Objects.requireNonNull(a, () -> "[" + LocalDateTime.now() + "]: arg must not be null");
    }
}
