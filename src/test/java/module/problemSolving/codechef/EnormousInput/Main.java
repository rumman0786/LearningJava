package module.problemSolving.codechef.EnormousInput;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author rumman
 * @since 12/14/18
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputCountAndDivisor = br.readLine().split(" ");

        int count = 0;
        int divisor = Integer.parseInt(inputCountAndDivisor[1]);
        for (int i = 0; i < Integer.parseInt(inputCountAndDivisor[0]); i++) {
            if (Integer.parseInt(br.readLine()) % divisor == 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
