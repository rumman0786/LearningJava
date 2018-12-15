package module.problemSolving.codechef.fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
* https://www.codechef.com/problems/FCTRL2
* */

/**
 * @author rumman
 * @since 12/15/18
 */
public class Main {

    public static final BigInteger[] FIBONACCI_MEMORY = new BigInteger[101];

    public static void main(String[] args) throws IOException {
        FIBONACCI_MEMORY[1] = BigInteger.valueOf(1);
        FIBONACCI_MEMORY[2] = BigInteger.valueOf(2);

        for (int i = 3; i < FIBONACCI_MEMORY.length; i++) {
            FIBONACCI_MEMORY[i] = BigInteger.valueOf(i).multiply(FIBONACCI_MEMORY[i-1]);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < lines; i++) {
            System.out.println(FIBONACCI_MEMORY[Integer.parseInt(reader.readLine())]);
        }
    }
}
