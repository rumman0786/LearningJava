package module.problemSolving.codechef.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

/**
 * @author rumman
 * @since 1/1/19
 */
public class NuclearReactors {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String line = null;
            StringBuilder output = new StringBuilder();

            while ((line = reader.readLine()) != null && line.trim().length() > 0) {
                String[] inputs = line.split(" ");
                int testCount = Integer.parseInt(inputs[0]);
                int perContainerMaxLimit = Integer.parseInt(inputs[1]);
                int[] container = new int[Integer.parseInt(inputs[2])];

                for (int i = 0; i < testCount; i++) {
                    for (int j = 0; j < container.length; j++) {
                        if (container[j] < perContainerMaxLimit) {
                            container[j] += 1;
                            break;
                        } else {
                            container[j] = 0;
                        }
                    }
                }

                StringJoiner outputLine = new StringJoiner(" ");
                for (int element :  container) {
                    outputLine.add(String.valueOf(element));
                }

                output.append(outputLine.toString())
                        .append(System.lineSeparator());
            }

            System.out.println(output.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
