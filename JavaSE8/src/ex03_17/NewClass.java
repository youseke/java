package ex03_17;

import ex03.CommonUtil;
import java.util.function.Consumer;
import org.junit.Test;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass implements CommonUtil {

    @Override
    @Test
    public void perform() {
        doInParallelAsync(
                () -> {
                    if (System.currentTimeMillis() % 2 == 1) {
                        throw new RuntimeException("Exception in First");
                    } else {
                        System.out.println("First OK");
                    }
                },
                () -> {
                    if (System.currentTimeMillis() % 2 == 1) {
                        throw new RuntimeException("Exception in Second");
                    } else {
                        System.out.println("Second OK");
                    }
                },
                (t) -> System.out.println(t.getMessage())
        );
    }

    public void doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable> handler) {
        Thread t = new Thread() {
            public void run() {
                new Thread(() -> {
                    try {
                        first.run();
                    } catch (Throwable t) {
                        handler.accept(t);
                    }
                }).start();
                new Thread(() -> {
                    try {
                        second.run();
                    } catch (Throwable t) {
                        handler.accept(t);
                    }
                }).start();
            }
        };
        t.start();
    }
}
