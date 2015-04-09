package ex08_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {

    public static void main(String[] args) {
        try {
            URL url = new URL("http", "localhost", 8080, "/manager/html");
            URLConnection connection = url.openConnection();
            String auth = "tomcat:s3cret";
            connection.setRequestProperty("Authorization", "Basic "
                    + Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8)));
            connection.connect();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                in.lines().forEach(System.out::println);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
