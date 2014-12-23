package ex05_05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {

    public static void main(String... args) {
        LocalDate birthDay = LocalDate.of(1986, 11, 17);
        LocalDate now = LocalDate.now();
        long days = ChronoUnit.DAYS.between(birthDay, now);
        System.out.println("I have been lived " + days + " days");
    }
}
