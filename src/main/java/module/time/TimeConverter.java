package module.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.MinguoDate;

/**
 * @author rumman
 * @since 9/4/18
 */
public class TimeConverter {

    public static ZonedDateTime instantToZonedDateTime(Instant instant) {
        return instant.atZone(ZoneId.of("Asia/Tokyo"));
    }

    public static Instant zonedDateTimeToInstant(ZonedDateTime zonedDateTime) {
        return zonedDateTime.toInstant();
    }

    public static MinguoDate getMinguoDate(LocalDate localDate) {
        return MinguoDate.from(localDate);
    }

    public static LocalDate getLocalDate(MinguoDate minguoDate) {
        return LocalDate.from(minguoDate);
    }
}
