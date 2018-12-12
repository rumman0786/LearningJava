package module.problemSolving.euler;

import org.junit.Test;

import java.math.BigInteger;

/**
 * @author rumman
 * @since 12/9/18
 */
public class Problem48 {

    /*
    * https://projecteuler.net/problem=48
    * */
    @Test
    public void selfPowerSumSubstring() {
        String sum = getSelfPowerSum(1000).toString();
        System.out.println(sum.substring(sum.length() - 10));
    }

    private BigInteger getSelfPowerSum(int limit) {
        BigInteger sum = BigInteger.ZERO;

        for (int i = 1; i <= limit; i++) {
            sum = sum.add(BigInteger.valueOf(i).pow(i));
        }

        return sum;
    }
}
