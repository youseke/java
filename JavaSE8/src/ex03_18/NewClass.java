package ex03_18;

import ex03.CommonUtil;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import org.junit.Test;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass implements CommonUtil{

    @FunctionalInterface
    public interface FunctionThatThrows<T, R> {
        R apply(T t) throws Exception;
    }

    @Override
    @Test(expected = RuntimeException.class)
    public void perform() {
        unchecked((String p) -> Files.readAllBytes(Paths.get(p)).length).apply("src/main/resources/dummy.txt");
    }

    public <T, R> Function<T, R> unchecked(FunctionThatThrows<T, R> f) {
        return (a) -> {
            try {
                return f.apply(a);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
