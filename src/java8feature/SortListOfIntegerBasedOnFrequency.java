package java8feature;

import java.util.*;
import java.util.stream.Collectors;

public class SortListOfIntegerBasedOnFrequency {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 4, 4, 4, 3, 3, 3, 3, 5, 2);

        // Sort approach 1
        List<Integer> integerList = input.stream().sorted((a, b) -> (b - a)).collect(Collectors.toList());
        System.out.println("Sort approach 1 :" + integerList);
        System.out.println("------------------------------");

        // Sort approach 2
        Collections.sort(input, (a, b) -> (b - a));
        System.out.println("Sort approach 2 :" + input);
        System.out.println("------------------------------");
        //--------------------------------------------------------------------------------------

        // Approach 1
        List<Integer> outCome = input.stream().sorted(Comparator.reverseOrder())
                .sorted((a, b) -> {
                    int freqA = Collections.frequency(input, a);
                    int freqB = Collections.frequency(input, b);
                    return Integer.compare(freqB, freqA); // descending
                })
                .collect(Collectors.toList());

        System.out.println("Approach 1: " + outCome);
        System.out.println("------------------------------");

        // Approach 2
        // Step 1: Frequency map
        Map<Integer, Long> collect = input.stream().sorted(Comparator.reverseOrder())
                .collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()));

        // Step 2: Sort the entries by frequency (descending)

        List<Map.Entry<Integer, Long>> lists = collect.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()).collect(Collectors.toList());

        // Step 3: Add repeated values based on frequency
        List<Integer> finalResult = new ArrayList<>();
        for (Map.Entry<Integer, Long> list : lists) {
            for (int i = 0; i < list.getValue(); i++) {
                finalResult.add(list.getKey());
            }
        }
        System.out.println("Approach 2: " + finalResult);

    }
}
