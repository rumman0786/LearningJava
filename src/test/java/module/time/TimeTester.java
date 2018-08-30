package module.time;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author rumman
 * @since 8/30/18
 */
public class TimeTester {

    @Test
    public void dobTest() {
        Assert.assertEquals(APJAbdulKalam.dateOfBirth().toString(), "1931-10-15");
    }
}
