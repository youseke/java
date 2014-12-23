package ex05_01;

import java.time.LocalDate;

public class ProgrammersDay {

	public static void main(String... args) {
		for (int i = 2000; i < 2020; i++) {
			LocalDate programmersDay = LocalDate.ofYearDay(i, 256);
			System.out.println(programmersDay);
		}
	}
}
