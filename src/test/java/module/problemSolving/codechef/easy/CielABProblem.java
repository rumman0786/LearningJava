package module.problemSolving.codechef.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author rumman
 * @since 12/25/18
 */
public class CielABProblem {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String line = null;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                String [] operands = line.split(" ");
                int output = Integer.parseInt(operands[0]) - Integer.parseInt(operands[1]);
                output = (output % 10 == 9) ? output - 1 : output + 1;

                stringBuilder.append(output).append(System.lineSeparator());
            }

            System.out.println(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
