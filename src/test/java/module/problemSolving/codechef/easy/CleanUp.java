package module.problemSolving.codechef.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author rumman
 * @since 12/30/18
 */
public class CleanUp {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCount = Integer.parseInt(reader.readLine());

            StringBuilder output = new StringBuilder();

            for (int i = 0; i < testCount; i++) {
                String[] totalFinished = reader.readLine().split(" ");
                int totalTask = Integer.parseInt(totalFinished[0]);
                int finished = Integer.parseInt(totalFinished[1]);

                boolean[] taskCompleted = new boolean[totalTask + 1];
                taskCompleted[0] = true;
                String completedTasks = reader.readLine();
                if (finished > 0 && Objects.nonNull(completedTasks) && completedTasks.trim().length() > 0) {
                    for (String index : completedTasks.trim().split(" ")) {
                        taskCompleted[Integer.parseInt(index)] = true;
                    }
                }

                boolean flag = true;
                StringJoiner line1 = new StringJoiner(" ");
                StringJoiner line2 = new StringJoiner(" ");
                for (int j = 1; j < taskCompleted.length; j++) {
                    if (!taskCompleted[j]) {
                        if (flag) {
                            line1.add(String.valueOf(j));
                        } else {
                            line2.add(String.valueOf(j));
                        }
                        flag = !flag;
                    }
                }

                output.append(line1.toString()).append(System.lineSeparator());
                output.append(line2.toString()).append(System.lineSeparator());
            }

            System.out.println(output.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
