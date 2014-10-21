package ex02_03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 *
 * @author Tohtetsu Choh
 */
public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Starting...");
        String contents = new String(Files.readAllBytes(Paths.get("src\\ex02_03\\alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // words.stream().forEach(System.out::println);
        long startTime = System.nanoTime();
        long n = words.parallelStream().filter(s -> s.length() > 5).count();
        long finishTime = System.nanoTime();

        System.out.println((finishTime - startTime) + " nano sec is taken for parallel stream and the result is " + n);

        startTime = System.nanoTime();
        n = words.parallelStream().filter(s -> s.length() > 5).count();
        finishTime = System.nanoTime();

        System.out.println((finishTime - startTime) + " nano sec is taken for normal stream and the result is " + n);
    }
}
