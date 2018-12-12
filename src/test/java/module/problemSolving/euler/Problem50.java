package module.problemSolving.euler;

import org.junit.Test;

/**
 * @author rumman
 * @since 12/12/18
 */
public class Problem50 {

    /**
     * https://projecteuler.net/problem=50
     * */

    public static int size = 1000001;
    public static int primeCount = 0;
    public static final boolean[] PRIME_MARKERS = new boolean[size];
    public static final int[] PRIMES = new int[size];

    public static int maxChainPrime = -1;
    public static int maxChainLength = 0;

    @Test
    public void consecutivePrime() {
        generatePrime();
        findConsecutivePrimeSum();

        System.out.println(maxChainPrime + " : " + maxChainLength);
    }

    private void findConsecutivePrimeSum() {
        for (int i = 0; i < primeCount; i++) {

            for (int j = 0; j < primeCount; j++) {

                int sum = 0;
                int chainLength = 0;
                for (int k = j; sum <= PRIMES[i] && k < primeCount; k++) {

                    if (sum == PRIMES[i]) {

                        if (chainLength >= maxChainLength) {
                            maxChainPrime = PRIMES[i];
                            maxChainLength = chainLength;
                        }
                    }

                    sum = sum + PRIMES[k];
                    chainLength++;
                }
            }
        }
    }

    private void generatePrime() {
        for (int i = 2; i < size; i++) {
            PRIME_MARKERS[i] = true;
        }

        for (int i = 2; i < size; i++) {
            for (int j = 2; i * j < size; j++) {
                if (PRIME_MARKERS[i * j]) {
                    PRIME_MARKERS[i * j] = false;
                }
            }
        }

        for (int i = 2; i < size; i++) {
            if (PRIME_MARKERS[i]) {
                PRIMES[primeCount++] = i;
            }
        }
    }
}
