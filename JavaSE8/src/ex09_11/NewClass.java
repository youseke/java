package ex09_11;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class NewClass {
	public static void main(String[] args) {
		try {
			scan();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void scan() throws IOException, InterruptedException {
		ProcessBuilder builder = new ProcessBuilder("grep", "-ohr", "-E", "-I",
				"--color=never", "(\\d{4}[ -]){3}\\d{4}",
				System.getProperty("java.io.tmpdir")).redirectOutput(Paths.get(
				System.getProperty("user.home"), "cards.txt").toFile());
		builder.start().waitFor(5, TimeUnit.MINUTES);
	}
}
