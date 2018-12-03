package module.problemSolving.euler;

import org.junit.Test;

/**
 * @author rumman
 * @since 12/3/18
 */
public class Problem14 {

    /*
    *
    * https://projecteuler.net/problem=14
    *
    * */
    int[] collatzLengthMemory= new int[1000001];

    @Test
    public void longestCollatzSequence() {

        int maxcollatzLength = -1;
        int maxcollatzLengthCandidate = -1;

        for (int i = 2; i <= 1000000; i++) {
            int currentCollatzLength = getCollatzLength(i);

            if (maxcollatzLength <= currentCollatzLength) {
                maxcollatzLength = currentCollatzLength;
                maxcollatzLengthCandidate = i;
            }
        }

        System.out.println(maxcollatzLengthCandidate + " : " + maxcollatzLength);

    }

    public int getCollatzLength(int subject) {

        if (collatzLengthMemory[subject] > 0) {
            return collatzLengthMemory[subject];
        }

        int length = 0;

        long operand = subject;

        while (operand >= 1) {

            length++;

            operand = (operand % 2 == 0) ? (operand / 2) : (3 * operand + 1);

            if (operand == 1) {
                break;
            }
        }

        collatzLengthMemory[subject] = length;

        return length;
    }
}
