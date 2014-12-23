package ex05_02;

import java.time.LocalDate;

public class NewClass {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.of(2000, 2, 29);
		// plus one year: 2001-02-28
		System.out.println(localDate.plusYears(1));
		// plus four years: 2004-02-29
		System.out.println(localDate.plusYears(4));
		// plus one year four times: 2004-02-28
		LocalDate date = localDate;
		for (int i = 0; i < 4; i++) {
			date = date.plusYears(1);
		}
		System.out.println(date);

	}

}
