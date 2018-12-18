package module.problemSolving.codechef.sum;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author rumman
 * @since 12/18/18
 */
public class SumofDigits {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < testCaseCount; i++) {
            builder.append(getSumOfDigits(reader.readLine()))
                    .append(System.lineSeparator());
        }

        System.out.println(builder.toString());
    }

    @Test
    public void testSumOfDigits() {
        Assert.assertEquals(54, getSumOfDigits("999999"));
    }

    public static int getSumOfDigits(String input) {
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            sum += Character.getNumericValue(input.charAt(i));
        }

        return sum;
    }
}
