package java8feature;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {
    public static void main(String[] args) {
        String s1 = "Kaushal";
        String s2 = "Saurabh";

        if (s1.length() == s2.length()) {
            String v1 = s1.toLowerCase().chars().sorted().mapToObj(m -> String.valueOf((char) m)).collect(Collectors.joining());
            String v2 = s2.toLowerCase().chars().sorted().mapToObj(m -> String.valueOf((char) m)).collect(Collectors.joining());
            System.out.println(v1.equals(v2) ? "Anagram" : "No");
        } else {
            System.out.println("Not an Anagram");
        }


        //-------------------------------------------------------------------------------------------------
        List<String> list = Arrays.asList("Kaushal", "Saurabh", "Aman", "lashauk", "bharuas");
        Map<String, List<String>> listMap = list.stream()
                .collect(Collectors.groupingBy(f -> f.toLowerCase().chars().sorted().mapToObj(m -> String.valueOf((char) m)).collect(Collectors.joining(""))));

        System.out.println(listMap);
        listMap.values().stream().filter(f -> f.size() > 1).forEach(System.out::println);

        //------------------------------------------------------------------------------------------------
        List<String> sortedCharsList = list.stream()
                .map(s -> s.toLowerCase().chars()                      // lowercase and get IntStream of chars
                        .sorted()                                     // sort the chars
                        .mapToObj(c -> String.valueOf((char) c))      // convert back to Character/Strings
                        .collect(Collectors.joining(""))              // join them as string
                )
                .collect(Collectors.toList());
        System.out.println(sortedCharsList);

    }
}
