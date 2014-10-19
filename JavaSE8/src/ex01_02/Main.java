package ex01_02;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		for (File s : listDirectories(new File("/")))
			System.out.println(s.getName());
	}

	public static File[] listDirectories(File file) {
		return file.listFiles((File pathname) -> pathname.isDirectory());
	}

}
