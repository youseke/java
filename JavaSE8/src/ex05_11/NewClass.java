package ex05_11;

import java.time.Duration;
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
        ZonedDateTime from = ZonedDateTime.of(LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 5)), ZoneId.of("Europe/Berlin"));
        ZonedDateTime to = ZonedDateTime.of(LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 40)), ZoneId.of("America/Los_Angeles"));
        Duration between = Duration.between(from.toInstant(), to.toInstant());
        System.out.println(between.toHours() + " hours " + between.toMinutes() % 60 + " mins");
    }
}
