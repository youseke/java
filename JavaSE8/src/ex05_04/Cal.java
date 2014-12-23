package ex05_04;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Cal {

    public static void main(String... args) {
        int year = Integer.valueOf(args[1]);
        int month = Integer.valueOf(args[0]);
        LocalDate start = LocalDate.of(year, month, 1);
        int duration = start.plusMonths(1).getDayOfYear() - start.getDayOfYear();

        System.out.println("Mon\tTue\tWen\tThu\tFri\tSat\tSun");
        for (int i = 1; i < start.getDayOfWeek().getValue(); i++) {
            System.out.print(" \t");
        }
        for (int i = 1; i <= duration; i++) {
            System.out.print(i);
            if (start.plusDays(i - 1).getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                System.out.println();
            } else {
                System.out.print("\t");
            }
        }
        System.out.println();
    }
}
