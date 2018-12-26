package module.problemSolving.codechef.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author rumman
 * @since 12/26/18
 */
public class RacingHorses {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCount = Integer.parseInt(reader.readLine());

            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < testCount; i++) {
                int arraySize = Integer.parseInt(reader.readLine());
                int [] array = new int[arraySize];
                String [] inputs = reader.readLine().split(" ");
                int j = 0;
                for (String val: inputs) {
                    array[j++] = Integer.parseInt(val);
                }

                Arrays.sort(array);

                int minDiff = Integer.MAX_VALUE;
                for (int k = 1; k < array.length; k++) {
                    int newDiff = array[k] - array[k-1];
                    if (minDiff > newDiff) {
                        minDiff = newDiff;
                    }
                }

                builder.append(minDiff).append(System.lineSeparator());
            }

            System.out.println(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
