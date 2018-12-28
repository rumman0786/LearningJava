package module.problemSolving.codechef.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author rumman
 * @since 12/28/18
 */
public class CoinFlip {

    private static final int HEAD = 1;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCount = Integer.parseInt(reader.readLine());

            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < testCount; i++) {
                int gameCount = Integer.parseInt(reader.readLine());

                for (int j = 0; j < gameCount; j++) {
                    String[] inputs = reader.readLine().split(" ");
                    int coinInitialSide = Integer.parseInt(inputs[0]);
                    int numberOfCoins = Integer.parseInt(inputs[1]);
                    int coinSideToCount = Integer.parseInt(inputs[2]);

                    int heads = 0;
                    int tails = 0;

                    int halfOfNumberOfCouns = numberOfCoins / 2;
                    if (numberOfCoins % 2 == 0) {
                        heads = halfOfNumberOfCouns;
                        tails = halfOfNumberOfCouns;
                    } else {
                        if (coinInitialSide == HEAD) {
                            heads = halfOfNumberOfCouns;
                            tails = halfOfNumberOfCouns + 1;
                        } else {
                            tails = halfOfNumberOfCouns;
                            heads = halfOfNumberOfCouns + 1;
                        }
                    }

                    builder.append(coinSideToCount == HEAD ? heads : tails)
                            .append(System.lineSeparator());
                }
            }

            System.out.println(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
