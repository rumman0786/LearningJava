package module.time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author rumman
 * @since 9/4/18
 */
public class TimeConverter {

    public static ZonedDateTime instantToZonedDateTime(Instant instant) {
        return instant.atZone(ZoneId.of("Asia/Tokyo"));
    }
}
