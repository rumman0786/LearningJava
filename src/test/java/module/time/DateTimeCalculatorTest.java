package module.time;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 * @author rumman
 * @since 9/6/18
 */
public class DateTimeCalculatorTest {

    @Test
    public void testPeriodBoundary() {
        LocalDate start = LocalDate.of(2018, Month.SEPTEMBER, 1);
        LocalDate end = LocalDate.of(2018, Month.SEPTEMBER, 30);

        Period expected = Period.of(0,0, 29);
        Assert.assertEquals(expected, DateTimeCalculator.getPeriod(start, end));

        LocalDate start2 = LocalDate.of(2018, Month.SEPTEMBER, 1);
        LocalDate end2 = LocalDate.of(2018, Month.SEPTEMBER, 1);

        Period expected2 = Period.of(0,0, 0);
        Assert.assertEquals(expected2, DateTimeCalculator.getPeriod(start2, end2));

        LocalDate start3 = LocalDate.of(2018, Month.SEPTEMBER, 1);
        LocalDate end3 = LocalDate.of(2018, Month.OCTOBER, 1);

        Period expected3 = Period.of(0,1, 0);
        Assert.assertEquals(expected3, DateTimeCalculator.getPeriod(start3, end3));

        LocalDate start4 = LocalDate.of(2018, Month.FEBRUARY, 1);
        LocalDate end4 = LocalDate.of(2018, Month.MARCH, 1);

        Period expected4 = Period.of(0,1, 0);
        Assert.assertEquals(expected4, DateTimeCalculator.getPeriod(start4, end4));
    }
}
