package module.time;

import org.junit.Test;

import java.time.Instant;

import static module.time.TimeConverter.instantToZonedDateTime;

/**
 * @author rumman
 * @since 9/4/18
 */
public class TimeConverterTest {

    @Test
    public void testInstantToZonedDateTime() {
        System.out.println(instantToZonedDateTime(Instant.now()));
    }
}
