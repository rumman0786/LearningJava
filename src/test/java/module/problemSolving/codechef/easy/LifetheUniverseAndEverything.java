package module.problemSolving.codechef.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author rumman
 * @since 12/23/18
 */
public class LifetheUniverseAndEverything {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = null;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null && !line.equals("42")) {
                builder.append(line).append(System.lineSeparator());
            }

            System.out.println(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
