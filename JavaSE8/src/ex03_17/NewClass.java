package ex03_17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {

    public static void doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable> handler) {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    ExecutorService pool = Executors.newCachedThreadPool();
                    pool.submit(first);
                    pool.submit(second);
                    pool.shutdown();
                    pool.awaitTermination(1, TimeUnit.HOURS);
                } catch (Throwable t) {
                    handler.accept(t);
                }
            }
        };
        t.start();
    }
}
