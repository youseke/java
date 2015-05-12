package ex09_07;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NewClass {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.google.com/");
			try (InputStream is = url.openStream()) {
				Files.copy(is, Paths.get(System.getProperty("java.io.tmpdir"),
						"test.html"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
