package module.time;

import org.junit.Assert;
import org.junit.Test;

import java.time.*;
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

    @Test
    public void testFirstSunday() {
        LocalDate firstSundaySeptember = LocalDate.of(2018, Month.SEPTEMBER, 2);
        Assert.assertEquals(firstSundaySeptember, getFirstSunday(LocalDate.now()));
    }

    @Test
    public void testLastThursday() {
        LocalDate lastThursdaySeptember = LocalDate.of(2018, Month.SEPTEMBER, 27);
        Assert.assertEquals(lastThursdaySeptember, getLastThursday(LocalDate.now()));
    }

    @Test
    public void testIsLeapYear() {
        Assert.assertFalse(isLeapYear(2018));
        Assert.assertTrue(isLeapYear(2016));
    }

    @Test
    public void testDayOfBirthday() {
        Assert.assertNotEquals(DayOfWeek.TUESDAY, dayOfBirthDay(2018));
        Assert.assertEquals(DayOfWeek.SATURDAY, dayOfBirthDay(2018));
    }

    @Test
    public void testNextBirthday() {
        Assert.assertEquals(LocalDate.of(2018, Month.NOVEMBER, 10),
                getNextBirthday(LocalDate.of(1990, Month.NOVEMBER, 10)));
    }
}
