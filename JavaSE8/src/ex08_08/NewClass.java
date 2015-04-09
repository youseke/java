package ex08_08;

import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {

    @Test(expected = ClassCastException.class)
    public void perform() {
        Queue<URL> queue = Collections.checkedQueue(new LinkedList<>(), URL.class);
        test(queue);
    }

    @SuppressWarnings("unchecked")
    public void test(Queue queue) {
        queue.add("test");
    }
}
