package module.time;

import java.time.*;
import java.time.chrono.MinguoDate;
import java.time.temporal.TemporalAdjusters;

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

    public static LocalDate getFirstSunday(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));
    }

    public static LocalDate getLastThursday(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.THURSDAY));
    }

    public static boolean isLeapYear(int year) {
        LocalDate leapYearCandidate = LocalDate.of(year, Month.FEBRUARY, 1);
        return leapYearCandidate.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth() == 29;
    }

    public static DayOfWeek dayOfBirthDay(int year) {
        return LocalDate.of(year, Month.NOVEMBER, 10).getDayOfWeek();
    }
}
