package InterviewQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class InterviewQ16_LongestPreFix {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("Kaushal", "Kanak", "Komal", "Krish");
        Collections.sort(input, Comparator.reverseOrder());

        // Using Java8
        AtomicReference<String> value = new AtomicReference<>(input.get(0));

        input.forEach(s -> {
            while (!s.startsWith(value.get())) {
                value.set(value.get().substring(0, value.get().length() - 1));
                if (value.get().isEmpty()) {
                    value.set("");
                    break;
                }
            }
        });

        System.out.println("Using java 8 Common prefix: " + value.get());

        // Using for loop traditional
        String firstValue = input.get(0);
        for (String s : input) {
            while (!s.startsWith(firstValue)) { // s.indexOf(firstValue) != 0
                firstValue = firstValue.substring(0, firstValue.length()-1);
                if (firstValue.isEmpty()) {
                    firstValue = "";
                    break;
                }
            }
        }

        System.out.println("Using traditional for loop Common prefix: " + value);

    }
}
