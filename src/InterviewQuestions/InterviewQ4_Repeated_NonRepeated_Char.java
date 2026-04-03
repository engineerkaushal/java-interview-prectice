package InterviewQuestions;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InterviewQ4_Repeated_NonRepeated_Char {
    public static void main(String[] args) {
        List<String> namesList = Arrays.asList("Kaushal", "Saurabh", "Anu", "Baby", "Shivani");
        String input = "Kaushal";

        // First Non Repeated Char
        Map<String, Long> longMap = input.toUpperCase().chars()
                .mapToObj(m -> String.valueOf((char) m))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        String orElse = longMap.entrySet().stream().filter(f -> f.getValue() == 1).map(m -> m.getKey()).findFirst().orElse(null);
        System.out.println(orElse == null ? "Not found" : "First Non Repeated Char is : " + orElse);

        // Non Repeated Char list
        List<String> list1 = longMap.entrySet().stream()
                .filter(f -> f.getValue() == 1)
                .map(m -> m.getKey()).collect(Collectors.toList());
        System.out.println("Non Repeated chars : " + list1);

        // Repeated char list
        List<String> list2 = longMap.entrySet().stream()
                .filter(f -> f.getValue() > 1)
                .map(m -> m.getKey()).collect(Collectors.toList());
        System.out.println("Repeated chars : " + list2);


        namesList.forEach(value -> {
            Map<String, Long> valueMap = value.toUpperCase().chars()
                    .mapToObj(m -> String.valueOf((char) m))
                    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
            String result = valueMap.entrySet().stream().filter(f -> f.getValue() == 1).map(m -> m.getKey()).findFirst().orElse(null);
            System.out.println(value + " : " + result);
        });
    }
}
