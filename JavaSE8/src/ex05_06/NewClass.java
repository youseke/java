package ex05_06;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {

    public static void main(String... args) {
        LocalDate start = LocalDate.of(1900, 1, 1);
        LocalDate to = LocalDate.of(2000, 1, 1);
        long days = ChronoUnit.DAYS.between(start, to.minusDays(1));
        for (int i = 0; i < days; i++) {
            LocalDate date = start.plusDays(i);
            if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY) && date.getDayOfMonth() == 13) {
                System.out.println(date);
            }
        }
    }
}
