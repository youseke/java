package ex01_01;

import java.util.Comparator;

public class TestComparator implements Comparator<String> {
	public int compare(String first, String second) {
		System.out.println("The thread of comapre method is "
				+ Thread.currentThread().getName());
		return Integer.compare(first.length(), second.length());
	}
}
