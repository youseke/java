package ex03;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public interface CommonUtil {

    void perform();

    default List<String> getWordsAsList() {
        String content;
        try {
            content = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("/main/resources/alice.txt").toURI())), StandardCharsets.UTF_8);
            return Arrays.asList(content.split("[\\P{L}]+"));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    default String[] getWordsAsArray() {
        String content;
        try {
            content = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("/main/resources/alice.txt").toURI())), StandardCharsets.UTF_8);
            return content.split("[\\P{L}]+");
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
