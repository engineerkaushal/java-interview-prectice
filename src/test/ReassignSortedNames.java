package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReassignSortedNames {
    public static void main(String[] args) {
        String[] input = {"1-Kaushal", "10-Aakash", "2-Saurabh", "3-Shivani"};
        String[] output = sortByNumberWithSortedNames(input);
        System.out.print("{");
        System.out.print(String.join(", ", output));
        System.out.println("}");

    }
    public static String[] sortByNumberWithSortedNames(String[] input) {
        List<Integer> numbers = new ArrayList<>();
        List<String> names = new ArrayList<>();
        Arrays.stream(input).forEach(v -> {
            String[] splitValue = v.split("-");
            numbers.add(Integer.parseInt(splitValue[0]));
            names.add(splitValue[1]);
        });
        Collections.sort(numbers);
        Collections.sort(names);
        List<String> finalOutput = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            finalOutput.add(numbers.get(i) + "-" + names.get(i));
        }

        return finalOutput.toArray(new String[0]);
    }
}
