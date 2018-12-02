package module.problemSolving.euler;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rumman
 * @since 12/2/18
 */
public class Problem12 {

    /**
     * problem url: https://projecteuler.net/problem=12
     */
    @Test
    public void getTriangularNumberDivisor() {

        int triangularNumber = 1;

        for (int i = 2; ; i++) {

            triangularNumber = triangularNumber + i;

            List<Integer> divisors = getDivisors(triangularNumber);

            if (divisors.size() >= 500) {
                System.out.println(triangularNumber + " : " + divisors.size());
                break;
            }
        }
    }

    private List<Integer> getDivisors(int divisible) {
        List<Integer> divisors = new ArrayList<>();

        divisors.add(1);

        for (int divisor = 2; divisor * divisor <= divisible; divisor++) {
            if (divisible % divisor == 0) {
                divisors.add(divisor);
                divisors.add(divisible / divisor);
            }
        }

        divisors.add(divisible);

        return divisors;
    }
}
