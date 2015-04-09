package ex08_15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import org.junit.Test;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {

    @Test
    public void perform() {
        try {
            grep(Pattern.compile("(?m)^Alice"),
                    Paths.get(this.getClass().getResource("/alice.txt").toURI()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void grep(Pattern pattern, Path path) throws IOException {
        Files.lines(path).filter(pattern.asPredicate()).forEach(System.out::println);
    }
}
