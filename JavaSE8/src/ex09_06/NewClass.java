package ex09_06;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class NewClass {
	public static void main(String[] args) {
		try {
			List<String> lines = Files.readAllLines(Paths.get(NewClass.class
					.getResource("src/main/resources/alice.txt").toURI()));
			Collections.reverse(lines);
			Files.write(Paths.get(System.getProperty("java.io.tmpdir"),
					"alice.txt"), lines);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
