package ex09_01;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class NewClass {
	public static void main(String[] args) {
		try {
			perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void perform() throws Exception {
		Scanner in = null;
		PrintWriter out = null;
		try {
			in = new Scanner(Paths.get(NewClass.class.getResource("src/main/resources/alice.txt")
					.toURI()));
			try {
				out = new PrintWriter("src/main/resources/fake/alice.txt");
				while (in.hasNext())
					out.println(in.next().toLowerCase());
			} finally {
				if (out != null) {
					out.close();
				}
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}
}
