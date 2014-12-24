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
    
    public static void main(String[] args) throws IOException, InterruptedException {
        long[] count = {0, 0};
        System.out.println("Starting...");
        String contents = new String(Files.readAllBytes(Paths.get("src/main/resources/alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        for (String w : words) {
            new Thread(() -> {
                if (w.length() > 1) {
                    count[0]++;
                }
            }).start();
        }
        Thread.sleep(2000);
        count[1] = words.stream().count();
        System.out.println(Arrays.toString(count));
        System.out.println("End");
    }
}
