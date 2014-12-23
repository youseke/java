package ex05_10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 *
 * @author Tohtetsu Choh
 */
public class NewClass {

    public static void main(String... args) {
        ZonedDateTime from = ZonedDateTime.of(LocalDateTime.of(LocalDate.now(), LocalTime.of(3, 5)), ZoneId.of("America/Los_Angeles"));
        ZonedDateTime to = from.plusHours(10);
        ZonedDateTime local = ZonedDateTime.ofInstant(to.toInstant(), ZoneId.of("Europe/Berlin"));
        System.out.println(local);
    }
}
