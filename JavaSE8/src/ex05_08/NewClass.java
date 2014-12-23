package ex05_08;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 *
 * @author tohtetsu
 */
public class NewClass {

    public static void main(String... args) {
        ZoneId.getAvailableZoneIds().stream().forEach(id -> {
            System.out.print(id + " ");
            System.out.println(ZonedDateTime.now(ZoneId.of(id)).getOffset());
        });
    }
}
