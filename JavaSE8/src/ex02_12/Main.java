package ex02_12;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.stream.Stream;

/**
 *
 * @author Tohtetsu Choh
 */
public class Main {

    public static void main(String[] args) throws IOException {
        AtomicIntegerArray shortWords = new AtomicIntegerArray(12);
        String contents = new String(Files.readAllBytes(Paths.get("src\\alice.txt")), StandardCharsets.UTF_8);
        Stream<String> words = Arrays.asList(contents.split("[\\P{L}]+")).stream();
        words.parallel().forEach(
                s -> {
                    if (s.length() < 12) shortWords.getAndIncrement(s.length());
                });
        System.out.println(shortWords);
    }
}
