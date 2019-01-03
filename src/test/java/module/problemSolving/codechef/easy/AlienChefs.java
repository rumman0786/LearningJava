package module.problemSolving.codechef.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rumman
 * @since 1/3/19
 */
public class AlienChefs {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int testCaseCount = Integer.parseInt(reader.readLine());
            StringBuilder output = new StringBuilder();

            List<int[]> timeRangeContainer = new ArrayList<>();
            for (int i = 0; i < testCaseCount; i++) {
                int[] timeRange = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                timeRangeContainer.add(timeRange);
            }

            int alienCount = Integer.parseInt(reader.readLine());
            for (int i = 0; i < alienCount; i++) {

                int[] arrivalTimes = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                int count = 0;
                for (int[] timeRange : timeRangeContainer) {
                    for (int j = 1; j < arrivalTimes.length; j++ ) {
                        if (timeRange[0] <= arrivalTimes[j] && arrivalTimes[j] <= timeRange[1]) {
                            count++;
                            break;
                        }
                    }
                }

                output.append(count).append(System.lineSeparator());
            }

            System.out.println(output.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
