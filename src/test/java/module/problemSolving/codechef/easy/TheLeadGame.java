package module.problemSolving.codechef.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author rumman
 * @since 12/22/18
 */
public class TheLeadGame {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int inputCount = Integer.parseInt(reader.readLine());

            int winningPlayer = 0;
            int winningLead = 0;

            int playerOneScore = 0;
            int playerTwoScore = 0;

            for (int i = 0; i < inputCount; i++) {
                String[] scores = reader.readLine().split(" ");
                playerOneScore += Integer.parseInt(scores[0]);
                playerTwoScore += Integer.parseInt(scores[1]);

                int diff = playerOneScore - playerTwoScore;
                if (diff > 0) {
                    if (diff > winningLead) {
                        winningLead = diff;
                        winningPlayer = 1;
                    }
                } else {
                    diff = diff * (-1);
                    if (diff > winningLead) {
                        winningLead = diff;
                        winningPlayer = 2;
                    }
                }
            }

            System.out.println(winningPlayer + " " + winningLead);
        }
    }
}
