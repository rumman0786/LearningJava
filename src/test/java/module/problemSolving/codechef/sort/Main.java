package module.problemSolving.codechef.sort;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * @author rumman
 * @since 12/17/18
 */
public class Main {

    /*
    * https://www.codechef.com/problems/TSORT
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = new int[Integer.parseInt(reader.readLine())];

        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = Integer.parseInt(reader.readLine().trim());
        }

        Arrays.sort(inputs);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int output : inputs) {
            writer.append(String.valueOf(output));
            writer.newLine();
        }

        writer.flush();
        writer.close();
    }

    @Test
    public void testSort() throws IOException {
        long start = System.nanoTime();

        int[] unsorted = {1, 3, 2, 5, 4, 6, 9, 7, 8};
        int[] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        Arrays.sort(unsorted);

        Assert.assertArrayEquals(sorted, unsorted);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int output : unsorted) {
            writer.append(String.valueOf(output));
            writer.newLine();
        }

        writer.flush();

        System.out.println(System.nanoTime() - start);

        writer.close();
    }
}
