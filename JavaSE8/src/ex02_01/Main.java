package ex02_01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Tohtetsu Choh
 */
public class Main {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        System.out.println("Starting...");
        String contents = new String(Files.readAllBytes(Paths.get("src\\alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        for (String w : words) {
            new Thread(() -> {
                if (w.length() > 1) {
                    Main.count++;
                }
            });
        }

        System.out.println(count);
        System.out.println("End");
    }
}
