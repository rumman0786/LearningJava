package module.problemSolving.euler;

import org.junit.Test;

/**
 * @author rumman
 * @since 11/30/18
 */
public class Problem4 {

    /**
     *   A palindromic number reads the same both ways. The largest palindrome made from the product of
     *   two 2-digit numbers is 9009 = 91 × 99.
     *
     *   Find the largest palindrome made from the product of two 3-digit numbers.
     */
    @Test
    public void largestPalindrome() {
        int maxPalindrome = Integer.MIN_VALUE;
        String numbersStr = "";
        for (int number1 = 999; number1 > 0; number1--) {
            for (int number2 = 999; number2 > 0; number2--) {
                int value = number1 * number2;
                if (isPalindrome(String.valueOf(value)) && value > maxPalindrome) {
                    maxPalindrome = value;
                    numbersStr = number1 + " " + number2 + " : ";
                }
            }
        }

        System.out.print(numbersStr);
        System.out.println(maxPalindrome);
    }

    private boolean isPalindrome(String comparable) {
        return new StringBuilder(comparable)
                .reverse()
                .toString()
                .equals(comparable);
    }
}
