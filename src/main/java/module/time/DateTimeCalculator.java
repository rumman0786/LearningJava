package module.time;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;

/**
 * @author rumman
 * @since 9/6/18
 */
public class DateTimeCalculator {

    public static Period getPeriod(LocalDate start, LocalDate end) {
        return Period.between(start, end);
    }

    public static Duration getDuration(Instant start, Instant end) {
        return Duration.between(start, end);
    }

    public static Comparator<Period> getPeriodComparator() {
        return Comparator.comparing(Period::getYears)
                .thenComparing(Period::getMonths)
                .thenComparing(Period::getDays);
    }
}
