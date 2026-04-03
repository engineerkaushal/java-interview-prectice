package InterviewQuestions;

import java.util.*;
import java.util.stream.Collectors;

public class InterviewQ7_SortListOfIntBasedOnFrequency {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 4, 4, 4, 3, 3, 3, 3, 5, 2);
        //Collections.sort(input, (a,b)-> b - a);
        //output: [3, 3, 3, 3, 4, 4, 4, 5, 2, 1]
        // Approach 1
        List<Integer> outCome = input.stream().sorted(Comparator.reverseOrder())
                .sorted((a, b) -> {
                    int freqA = Collections.frequency(input, a);
                    int freqB = Collections.frequency(input, b);
                    return Integer.compare(freqB, freqA); // descending
                })
                .collect(Collectors.toList());

        System.out.println("Approach 1: " + outCome);
    }
}
