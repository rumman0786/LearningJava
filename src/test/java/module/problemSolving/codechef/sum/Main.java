package module.problemSolving.codechef.sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author rumman
 * @since 12/17/18
 */
public class Main {

    /*
    * https://www.codechef.com/problems/FCTRL2
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int inputCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < inputCount; i++) {
            String[] inputs = reader.readLine().split(" ");
            System.out.println(sum(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])));
        }
    }

    public static int sum(int a, int b) {
        return a + b;
    }
}
