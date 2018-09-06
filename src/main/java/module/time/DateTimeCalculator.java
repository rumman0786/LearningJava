package module.time;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author rumman
 * @since 9/6/18
 */
public class DateTimeCalculator {

    public static Period getPeriod(LocalDate start, LocalDate end) {
        return Period.between(start, end);
    }
}
