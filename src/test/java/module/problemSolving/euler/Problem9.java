package module.problemSolving.euler;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rumman
 * @since 11/30/18
 */
public class Problem9 {

    /*
    *
    * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
    *
    *      a^2 + b^2 = c^2
    *
    * For example, 32 + 42 = 9 + 16 = 25 = 52.
    *
    * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
    * Find the product abc.
    *
    * */
    @Test
    public void pythagoreanTriplet() {
        Map<String, Integer> specialTriplet = getTriplet(1000);

        System.out.println("a = " + specialTriplet.get("a"));
        System.out.println("b = " + specialTriplet.get("b"));
        System.out.println("c = " + specialTriplet.get("c"));

        System.out.println("a * b * c = "
                + specialTriplet.values()
                .stream()
                .reduce(1, (a,b)-> a * b));
    }

    private Map<String, Integer> getTriplet(int summation) {
        Map<String, Integer> integerMap = new HashMap<>(3);

        for (int c = 1; ;c++) {
            for (int b = 1; b < c;b++) {
                for (int a = 1; a < b;a++) {
                    if ((a*a + b*b == c*c) && (a + b + c == summation)){
                        integerMap.put("a", a);
                        integerMap.put("b", b);
                        integerMap.put("c", c);

                        return integerMap;
                    }
                }
            }
        }
    }
}
