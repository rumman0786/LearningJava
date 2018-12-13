package module.problemSolving.codechef.atm;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author rumman
 * @since 12/13/18
 */
public class Main {

    /**
     * https://www.codechef.com/problems/HS08TEST
     */
    private static final BigDecimal WITHDRAW_CHARGE = BigDecimal.valueOf(0.50);
    private static final BigDecimal MULTIPLE = BigDecimal.valueOf(5);

    public static void main (String[] args) throws java.lang.Exception {
        java.io.BufferedReader r = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String[] input = r.readLine().split(" ");
        System.out.println(getBalance(new BigDecimal(input[0]), new BigDecimal(input[1])).setScale(2));
    }

    @Test
    public void problemTester() {
        System.out.println(getBalance(BigDecimal.valueOf(30), BigDecimal.valueOf(120.00)).setScale(2));
        System.out.println(getBalance(BigDecimal.valueOf(42), BigDecimal.valueOf(120.00)).setScale(2));
        System.out.println(getBalance(BigDecimal.valueOf(300), BigDecimal.valueOf(120.00)).setScale(2));
    }

    public static BigDecimal getBalance(BigDecimal withdrawAmount, BigDecimal initialBalance) {
        BigDecimal balanceLeft = initialBalance.subtract(withdrawAmount.add(WITHDRAW_CHARGE));
        return (BigDecimal.ZERO.compareTo(withdrawAmount.remainder(MULTIPLE)) == 0 && balanceLeft.compareTo(BigDecimal.ZERO) >= 0)
                ? balanceLeft : initialBalance;
    }
}
