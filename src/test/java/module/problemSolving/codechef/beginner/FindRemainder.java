package module.problemSolving.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author rumman
 * @since 12/27/18
 */
public class FindRemainder {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCount = Integer.parseInt(reader.readLine());

            for (int i = 0; i < testCount; i++) {
                String [] inputs = reader.readLine().split(" ");
                builder.append(Integer.parseInt(inputs[0]) % Integer.parseInt(inputs[1]))
                        .append(System.lineSeparator());
            }

            System.out.println(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
