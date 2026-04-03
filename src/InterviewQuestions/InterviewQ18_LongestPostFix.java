package InterviewQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewQ18_LongestPostFix {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("Kaushalah", "Kanakah", "Komalah", "Krisah");

        String firstValue = input.get(0);

        for (String s : input) {
            while (!s.endsWith(firstValue)) {
                firstValue = firstValue.substring(1);
                if (firstValue.isEmpty()) {
                    firstValue = "";
                    break;
                }
            }
        }

        System.out.println("Using traditional for loop Common postfix: " + firstValue);
    }
}
