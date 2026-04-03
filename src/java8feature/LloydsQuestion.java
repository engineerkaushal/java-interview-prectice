package java8feature;

import java.util.*;

public class LloydsQuestion {

    public static void main(String[] args) {
        int[] input = {17, 14, 15, 15, 10, 8, 12, 3, 1, 4};
        //output: {17, 15, 12, 4}

        System.out.println(getResult(input));

        StringBuilder s1 = new StringBuilder("ABC");
        StringBuilder s2 = new StringBuilder("ABC");
        System.out.println(s1.toString() == s2.toString());
        System.out.println(s1.toString().equals(s2.toString()));


    }

    public static List<Integer> getResult(int[] input) {
        List<Integer> result = new ArrayList<>();
        Integer maxSoFar = Integer.MIN_VALUE;
        for (int i = input.length -1; i >= 0; i--) {
            if (input[i] > maxSoFar) {
                result.add(input[i]);
                maxSoFar = input[i];
            }
        }
        Collections.reverse(result);
        return result;
    }
}
