package ex02_13;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Tohtetsu Choh
 */
public class Main {

    public static void main(String[] args) throws IOException {

        String contents = new String(Files.readAllBytes(Paths.get("src\\alice.txt")), StandardCharsets.UTF_8);
        Stream<String> words = Arrays.asList(contents.split("[\\P{L}]+")).stream();
        Map<Integer, Long> m = words.filter(t -> t.length() < 12).collect(Collectors.groupingBy(t -> t.length(), Collectors.counting()));
        System.out.println(m);
    }
}
