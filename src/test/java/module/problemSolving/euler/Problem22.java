package module.problemSolving.euler;

import org.junit.Test;
import util.GeneralUtils;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author rumman
 * @since 12/6/18
 */
public class Problem22 {

    /*
    * https://projecteuler.net/problem=22
    * */
    @Test
    public void printNames() {
        String filePath = "./src/main/resources/p022_names.txt";
        String names = GeneralUtils.getContent(filePath);

        List<String> namesList = Arrays.asList(names.replace("\"","").split(","));

        Collections.sort((namesList));

        System.out.println(getNamesSum(namesList).toString());
    }

    private BigInteger getNamesSum(List<String> names){
        BigInteger sum = BigInteger.valueOf(0);

        for (String name: names) {
            int order = names.indexOf(name) + 1;
            int weight = order * getAlphabeticalValue(name);

            sum = sum.add(BigInteger.valueOf(weight));
        }

        return sum;
    }

    private int getAlphabeticalValue(String name){
        int value = 0;
        for (int i = 0; i < name.length();i++) {
            value = value + ((int)name.charAt(i) - 64);
        }

        return value;
    }
}
