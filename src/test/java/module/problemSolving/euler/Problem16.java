package module.problemSolving.euler;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author rumman
 * @since 12/4/18
 */
public class Problem16 {

    /*
    * https://projecteuler.net/problem=16
    * */
    @Test
    public void getPowSum() {
        BigDecimal bd = new BigDecimal(2);
        String result = bd.pow(1000).toString();

        long sum = 0;
        for (int i = 0; i < result.length(); i++) {
            sum = sum + Character.getNumericValue(result.charAt(i));
        }

        System.out.println(sum);
    }
}
