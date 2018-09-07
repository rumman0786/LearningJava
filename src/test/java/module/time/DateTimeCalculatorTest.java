package module.time;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void testPeriodUnits() {
        Period twenty24Months = Period.ofMonths(24);
        Period twoYears = Period.of(2, 0 , 0);

        System.out.println(String.format("Period:: twenty24Months: [%s], twoYears: [%s]",
                twenty24Months, twoYears));
        Assert.assertNotEquals(twenty24Months, twoYears);

        System.out.println(String.format("get(ChronoUnit.DAYS):: twenty24Months: [%s], twoYears: [%s]",
                twenty24Months.get(ChronoUnit.DAYS), twoYears.get(ChronoUnit.DAYS)));
        Assert.assertEquals(twenty24Months.get(ChronoUnit.DAYS), twoYears.get(ChronoUnit.DAYS));

        System.out.println(String.format("toTotalMonths():: twenty24Months: [%02d], twoYears: [%02d]",
                twenty24Months.toTotalMonths(), twoYears.toTotalMonths()));
        Assert.assertEquals(twenty24Months.toTotalMonths(), twoYears.toTotalMonths());

        System.out.println(String.format("getDays():: twenty24Months: [%02d], twoYears: [%02d]",
                twenty24Months.getDays(), twoYears.getDays()));
        Assert.assertEquals(twenty24Months.getDays(), twoYears.getDays());

        Period fromWeeks = Period.ofWeeks(40);
        System.out.println(String.format("Period.ofWeeks():: expected: [%02d], actual: [%02d]",
                280, fromWeeks.getDays()));
        Assert.assertEquals(280, fromWeeks.getDays());
    }

    @Test
    public void testPeriodMaths() {
        LocalDate january = LocalDate.now().withDayOfYear(1);
        LocalDate february = LocalDate.now().withMonth(2).withDayOfMonth(1);
        Period period = Period.between(february, january);

        Assert.assertTrue(period.isNegative());
        Assert.assertEquals(january, february.minusMonths(1));
        Assert.assertEquals(february, january.plusMonths(1));
    }

    @Test
    public void testPeriodNormalization() {
        Period twelveMonths = Period.ofMonths(12).withDays(13);
        Period oneYear = Period.ofYears(1).withDays(13);

        System.out.println(String.format("Period.normalized():: twelveMonths: [%s], oneYear: [%s]",
                twelveMonths.normalized(), oneYear.normalized()));
        Assert.assertEquals(twelveMonths.normalized(), oneYear.normalized());

        System.out.println(String.format("Period.normalized().getDays():: twelveMonths: [%s], oneYear: [%s]",
                twelveMonths.normalized().getDays(), oneYear.normalized().getDays()));
        Assert.assertEquals(twelveMonths.normalized().getDays(), oneYear.normalized().getDays());

        System.out.println(String.format("Period.normalized().toTotalMonths():: twelveMonths: [%s], oneYear: [%s]",
                twelveMonths.normalized().toTotalMonths(), oneYear.normalized().toTotalMonths()));
        Assert.assertEquals(twelveMonths.normalized().toTotalMonths(), oneYear.normalized().toTotalMonths());

        System.out.println(String.format("Period.normalized().get(ChronoUnit.DAYS):: twelveMonths: [%s], oneYear: [%s]",
                twelveMonths.normalized().get(ChronoUnit.DAYS), oneYear.normalized().get(ChronoUnit.DAYS)));
        Assert.assertEquals(twelveMonths.normalized().get(ChronoUnit.DAYS), oneYear.normalized().get(ChronoUnit.DAYS));
   }

   @Test
   public void testPeriodSorting() {
        List<Period> periods = Arrays.asList(
                Period.of(5,2,1),
                Period.of(2,6,10),
                Period.of(4,11,11),
                Period.of(1,6,2),
                Period.of(4,0,5)
        );

       periods.sort(DateTimeCalculator.getPeriodComparator());

       periods.forEach(period ->
               System.out.println(String.format("YEAR [%s], MONTH [%s], DAYS [%s]",
                       period.getYears(), period.getMonths(), period.getDays())));
   }
}
