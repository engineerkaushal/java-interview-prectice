package InterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewQ22_CommonOfLists {
    public static void main(String[] args) {
        List<String> stringValue1 = Arrays.asList("Kaushal", "Saurabh", "Anu", "Baby", "Shivani");
        List<String> stringValue2 = Arrays.asList("kaushal", "saurabh", "Anu", "Baby", "Shivani", "Ram");

        // Traditional approach
        List<String> result1 = new ArrayList<>();
        for (String s1 : stringValue1) {
            for (String s2 : stringValue2) {
                if (s1.equals(s2) && !result1.contains(s1)) {
                    result1.add(s1);
                }
            }
        }
        System.out.println("Using Traditional for loop : " + result1);

        // Using java 8
        List<String> list = stringValue1.stream().filter(stringValue2::contains).collect(Collectors.toList());
        System.out.println("Using Java 8 : " + list);

        // Using retainAll() method
        List<String> result2 = new ArrayList<>(stringValue1);
        result2.retainAll(stringValue2);
        System.out.println("Using retainAll() method : " + result2);


    }
}
