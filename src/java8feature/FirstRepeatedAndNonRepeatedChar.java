package java8feature;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepeatedAndNonRepeatedChar {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Kaushal", "Saurabh", "Abhishek");

        String input = "Kuasuhal";
        char result1 = firstRepeatedCharUsingTraditional(input, 1);
        System.out.println(result1);


        String result2 = firstRepeatedCharUsingJava8(input, 1);
        System.out.println(result2);

        Map<String, Map<Character, Long>> mapMap= list.stream().collect(Collectors.toMap( name -> name, name ->
             name.toLowerCase().chars().mapToObj(m -> (char)m).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        ));
        System.out.println(mapMap);
        // output: {Abhishak={a=2, b=1, s=1, h=2, i=1, k=1}, Saurabh={a=2, b=1, r=1, s=1, u=1, h=1}, Kaushal={a=2, s=1, u=1, h=1, k=1, l=1}}
    }

    // Traditional Approach
    public static char firstRepeatedCharUsingTraditional(String input, int num) {
        Map<Character, Long> map = new LinkedHashMap<>();
        int numCount = 0;

        for (char c : input.toCharArray()) {
            //map.put(c, (map.containsKey(c) ? map.get(c) : 0) + 1);
            map.put(c, map.getOrDefault(c, Long.valueOf(0)) +1);
        }

        for (Map.Entry<Character, Long> count : map.entrySet()) {
            if (count.getValue() > 1) { // first non repeated use "count.getValue() == 1"
                numCount++;
                if (numCount == num) {
                    return count.getKey();
                }
            }
        }
        return '\0';
    }

    // Using Java8
    public static String firstRepeatedCharUsingJava8(String input, int n) {

        LinkedHashMap<Character, Long> linkedHashMap = input.chars().mapToObj(m -> (char) m)
                .collect(Collectors.groupingBy(Function.identity(), // हर element को उसकी "original value" से group करें
                        LinkedHashMap::new, // LinkedHashMap में डालें ताकि insertion order बना रहे
                        Collectors.counting())); // हर group की गिनती करें (frequency)

        LinkedHashMap<Character, Long> lhm = input.chars().mapToObj(m -> (char) m)
                .collect(Collectors.groupingBy(e -> e, () -> new LinkedHashMap<>(), Collectors.counting()));

        List<Character> characters = linkedHashMap.entrySet().stream().filter(f -> f.getValue() > 1)
                .map(m -> m.getKey()).collect(Collectors.toList());
        System.out.println(characters);
        return !characters.isEmpty() && characters.size() > n  ? String.valueOf(characters.get(n-1))
                : !characters.isEmpty() && characters.size() < n
                ? "Given Integer value " + n +" is greater than List size, and list size is " + characters.size() : null;
    }
}
