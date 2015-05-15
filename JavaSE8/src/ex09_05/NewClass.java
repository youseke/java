package ex09_05;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NewClass {
	public static void main(String[] args) {
		try {
			byte[] bytes = Files.readAllBytes(Paths.get(NewClass.class
					.getResource("src/main/resources/alice.txt").toURI()));
			byte[] reversedBytes = new byte[bytes.length];
			for (int i = 0, j = bytes.length - 1; i < bytes.length; i++, j--) {
				reversedBytes[i] = bytes[j];
			}
			Files.write(Paths.get(System.getProperty("java.io.tmpdir"),
					"alice.txt"), reversedBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
