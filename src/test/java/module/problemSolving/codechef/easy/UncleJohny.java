package module.problemSolving.codechef.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author rumman
 * @since 12/23/18
 */
public class UncleJohny {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder stringBuilder = new StringBuilder();

            int inputCount = Integer.parseInt(reader.readLine());

            for (int i = 0; i < inputCount; i++) {
                int[] inputArray = new int[Integer.parseInt(reader.readLine())];
                String[] inputs = reader.readLine().split(" ");

                for (int n = 0; n < inputArray.length; n++) {
                    inputArray[n] = Integer.parseInt(inputs[n]);
                }

                int itemToFind = inputArray[Integer.parseInt(reader.readLine()) - 1];

                Arrays.sort(inputArray);

                for (int j = 0; j < inputArray.length; j++) {
                    if (inputArray[j] == itemToFind)
                        stringBuilder.append(j + 1).append(System.lineSeparator());
                }
            }

            System.out.print(stringBuilder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
