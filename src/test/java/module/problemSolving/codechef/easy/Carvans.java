package module.problemSolving.codechef.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author rumman
 * @since 1/2/19
 */
public class Carvans {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int testCaseCount = Integer.parseInt(reader.readLine());
            StringBuilder output = new StringBuilder();

            for (int i = 0; i < testCaseCount; i++) {
                int carCount = Integer.parseInt(reader.readLine());
                int[] carMaxSpeed = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int carOnMaxSpeedCount = 1;
                int maxAllowedSpeed = carMaxSpeed[0];
                for (int j = 1; j < carCount; j++) {
                    if (maxAllowedSpeed >= carMaxSpeed[j]) {
                        carOnMaxSpeedCount++;
                        maxAllowedSpeed = carMaxSpeed[j];
                    }

                }

                output.append(String.valueOf(carOnMaxSpeedCount))
                        .append(System.lineSeparator());
            }

            System.out.println(output.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
