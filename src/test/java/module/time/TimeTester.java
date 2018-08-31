package module.time;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.time.*;

/**
 * @author rumman
 * @since 8/30/18
 */
public class TimeTester {

    @Test
    public void dobTest() {
        Assert.assertEquals(APJAbdulKalam.dateOfBirth().toString(), "1931-10-15");
    }

    @Test
    public void dodTest() {
        Assert.assertEquals(APJAbdulKalam.dateOfDeath().toString(), "2015-07-27");
    }

    @Test
    public void dayOfWeekTest() {
        Matcher<DayOfWeek> dayOfBirthMatcher = IsEqual.equalTo(DayOfWeek.THURSDAY);
        Assert.assertThat(APJAbdulKalam.dateOfBirth().getDayOfWeek(),
                CoreMatchers.is(dayOfBirthMatcher));

        Matcher<DayOfWeek> dayOfDeathMatcher = IsEqual.equalTo(DayOfWeek.MONDAY);
        Assert.assertThat(APJAbdulKalam.dateOfDeath().getDayOfWeek(),
                CoreMatchers.is(dayOfDeathMatcher));

        LocalDate myBirthDate = LocalDate.of(1990, Month.NOVEMBER, 10);
        Matcher<DayOfWeek> myBirthday = IsEqual.equalTo(DayOfWeek.SATURDAY);
        Assert.assertThat(myBirthDate.getDayOfWeek(), CoreMatchers.is(myBirthday));

        Matcher<DayOfWeek> my30thBirthday = IsEqual.equalTo(DayOfWeek.TUESDAY);
        Assert.assertThat(myBirthDate.plusYears(30).getDayOfWeek(), CoreMatchers.is(my30thBirthday));
    }

    @Test
    public void lifeDurationTest() {
        Matcher<Long> daysLivedMatcher = CoreMatchers.is(IsEqual.equalTo(30601L));
        LocalDateTime birthDateTime = LocalDateTime.of(APJAbdulKalam.dateOfBirth(), LocalTime.now());
        LocalDateTime deathDateTime = LocalDateTime.of(APJAbdulKalam.dateOfDeath(), LocalTime.now());

        Assert.assertThat(Duration.between(birthDateTime, deathDateTime).toDays(), daysLivedMatcher);
    }
}
