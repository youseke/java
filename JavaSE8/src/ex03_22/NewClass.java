package ex03_22;

import ex03.CommonUtil;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass implements CommonUtil {

    @Test
    @Override
    public void perform() {
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "1", executor);
        try {
            future.thenApply(Integer::parseInt) //map
                    .thenCompose((a) -> CompletableFuture.supplyAsync(() -> 1 + a, executor)) //flatMap
                    .thenAccept(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
