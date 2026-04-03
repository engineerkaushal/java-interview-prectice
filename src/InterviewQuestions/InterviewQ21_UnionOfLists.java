package InterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterviewQ21_UnionOfLists {
    public static void main(String[] args) {
        List<String> stringValue1 = Arrays.asList("Kaushal", "Saurabh", "Anu", "Baby", "Shivani");
        List<String> stringValue2 = Arrays.asList("kaushal", "saurabh", "Anu", "Baby", "Shivani", "Ram");

        // Traditional approach
        List<String> result = new ArrayList<>();
        for (String s : stringValue1) {
            if (!result.contains(s.toLowerCase())) {
                result.add(s.toLowerCase());
            }
        }
        for (String s : stringValue2) {
            if (!result.contains(s.toLowerCase())) {
                result.add(s.toLowerCase());
            }
        }
        System.out.println("Using Traditional for loop : " + result);


        // Using Java 8
        List<String> list = Stream.concat(stringValue1.stream(), stringValue2.stream()).map(String::toLowerCase)
                .distinct().collect(Collectors.toList());

        System.out.println("Using java 8 : " + list);

        // Using addAll() method
        List<String> result2 = new ArrayList<>(stringValue1);
        result2.addAll(stringValue2);
        System.out.println("Using addAll() method : " + result2);

    }
}
