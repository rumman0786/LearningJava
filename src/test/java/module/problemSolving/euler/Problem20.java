package module.problemSolving.euler;

import org.junit.Test;

import java.math.BigInteger;

/**
 * @author rumman
 * @since 12/4/18
 */
public class Problem20 {

    /*
    * https://projecteuler.net/problem=20
    * */
    @Test
    public void getFactorialSum(){
        String factorial = getFactorial(100).toString();
        System.out.println(getSumOfDigits(factorial));
    }

    private BigInteger getFactorial(int factor) {
        BigInteger result = BigInteger.valueOf(1);

        for (int i = 2; i <= factor; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    private long getSumOfDigits(String digits) {
        long sum = 0;
        for (int i = 0; i < digits.length(); i++) {
            sum = sum + Character.getNumericValue(digits.charAt(i));
        }

        return sum;
    }
}
