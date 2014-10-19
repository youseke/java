package ex01_01;

import java.util.Arrays;
/*
 * 同じスレッドとなります。
 */
public class ArraySortTest {
	public static void main(String[] args) {
		String[] strings = { "test1", "test2" };
		System.out.println("The thread of sort mehotd is "
				+ Thread.currentThread().getName());
		Arrays.sort(strings, new TestComparator());

	}
}
