package ex01_04;

import java.io.File;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		
	}

	public static File[] sortsFiles(File[] files) {
		Arrays.sort(files, (File o1, File o2) -> {
			if (o1.isDirectory()) {
				if (!o2.isDirectory())
					return 1;
			} else {
				if (o2.isDirectory())
					return -1;
			}
			return Integer
					.compare(o1.getPath().length(), o2.getPath().length());
		});
		return files;
	}
}