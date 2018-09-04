package module.time;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.chrono.MinguoDate;

import static module.time.TimeConverter.*;

/**
 * @author rumman
 * @since 9/4/18
 */
public class TimeConverterTest {

    @Test
    public void testInstantToZonedDateTime() {
        System.out.println(Instant.now());
        System.out.println(instantToZonedDateTime(Instant.now()));
    }

    @Test
    public void testZonedDateTimeToInstant() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTimeToInstant(zonedDateTime));
    }

    @Test
    public void testGetMinguoDate() {
        System.out.println(LocalDate.now());
        System.out.println(getMinguoDate(LocalDate.now()));
    }

    @Test
    public void testGetLocalDate() {
        System.out.println(MinguoDate.now());
        System.out.println(getLocalDate(MinguoDate.now()));
    }
}
