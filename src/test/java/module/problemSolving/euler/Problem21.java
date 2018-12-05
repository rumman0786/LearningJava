package module.problemSolving.euler;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rumman
 * @since 12/5/18
 */
public class Problem21 {

    /*
    * https://projecteuler.net/problem=21
    * */
    public Set<Integer> amicableNumbers = new HashSet<>();

    @Test
    public void amicableNumberBelow1000Sum() {
        findAmicable(10000);
    }

    private void findAmicable(int limit) {

        for (int amicableCandidateA = 1; amicableCandidateA < limit; amicableCandidateA++) {
            List<Integer> divisors = getDivisors(amicableCandidateA);

            int amicableCandidateB = divisors.stream().mapToInt(i -> i).sum();

            int sum = getDivisors(amicableCandidateB).stream().mapToInt(i -> i).sum();

            if (amicableCandidateA == sum && amicableCandidateA != amicableCandidateB) {
                amicableNumbers.add(amicableCandidateA);
                amicableNumbers.add(amicableCandidateB);
            }
        }

        System.out.println(amicableNumbers);
        System.out.println(amicableNumbers.stream().mapToInt(i ->i).sum());

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

        return divisors;
    }
}
