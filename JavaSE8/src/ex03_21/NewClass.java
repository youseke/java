package ex03_21;

import ex03.CommonUtil;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass implements CommonUtil {

    @Test
    @Override
    public void perform() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> strFuture = executorService.submit(() -> "1");
        Future<Integer> intFuture = map(strFuture, Integer::parseInt);
        try {
            assertEquals(new Integer(1), intFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T, U> Future<U> map(Future<T> future, Function<T, U> function) {
        return new Future<U>() {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return false;
            }

            @Override
            public boolean isCancelled() {
                return false;
            }

            @Override
            public boolean isDone() {
                return true;
            }

            @Override
            public U get() throws InterruptedException, ExecutionException {
                return function.apply(future.get());
            }

            @Override
            public U get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return function.apply(future.get());
            }
        };
    }
}
