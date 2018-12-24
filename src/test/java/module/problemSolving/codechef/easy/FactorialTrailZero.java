package module.problemSolving.codechef.easy;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author rumman
 * @since 12/23/18
 */
public class FactorialTrailZero {
    private static long FIVE = 5L;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            StringBuilder output = new StringBuilder();

            int inputCount = Integer.parseInt(reader.readLine());
            for (int i = 0; i < inputCount; i++) {
                int input = Integer.parseInt(reader.readLine());
                output.append(getTrailingZeroesInFactorial(input))
                        .append(System.lineSeparator());
            }

            System.out.println(output.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkZeroCounter() {
        Assert.assertEquals(0, getTrailingZeroesInFactorial(4));
        Assert.assertEquals(1, getTrailingZeroesInFactorial(7));
        Assert.assertEquals(2, getTrailingZeroesInFactorial(10));
        Assert.assertEquals(12, getTrailingZeroesInFactorial(52));
    }

    private static int getTrailingZeroesInFactorial(long factor) {
        int count = 0;
        for (int i = 1; ; i++) {
            long multipleFive = (long) Math.pow(FIVE, i);

            if (multipleFive <= factor) {
                count += factor / multipleFive;
            } else {
                break;
            }
        }

        return count;
    }
}
