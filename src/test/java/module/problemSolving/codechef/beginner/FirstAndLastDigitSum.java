package module.problemSolving.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author rumman
 * @since 12/27/18
 */
public class FirstAndLastDigitSum {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            StringBuilder output = new StringBuilder();

            int inputCount = Integer.parseInt(reader.readLine());
            for (int i = 0; i < inputCount; i++) {
                String input = reader.readLine();

                int sum = 0;
                if (input != null && input.length() > 0) {
                    sum = Character.getNumericValue(input.charAt(0));
                    sum = (input.length() == 1) ? sum : sum + Character.getNumericValue(input.charAt(input.length() - 1));
                }

                output.append(sum).append(System.lineSeparator());
            }

            System.out.println(output.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
