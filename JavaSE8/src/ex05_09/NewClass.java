package ex05_09;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 *
 * @author tohtetsu
 */
public class NewClass {

    public static void main(String... args) {
        ZoneOffset plus = ZoneOffset.ofHours(1);
        ZoneOffset minus = ZoneOffset.ofHours(-1);
        ZoneId.getAvailableZoneIds().stream().forEach(id -> {
            ZoneOffset offSet = ZonedDateTime.now(ZoneId.of(id)).getOffset();
            if (offSet.compareTo(plus) >= 0 && offSet.compareTo(minus) <= 0) {
                System.out.print(id + " ");
                System.out.println(offSet);
            }
        });
    }
}
