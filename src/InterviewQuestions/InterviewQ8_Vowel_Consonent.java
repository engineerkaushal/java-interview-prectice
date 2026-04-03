package InterviewQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InterviewQ8_Vowel_Consonent {
    public static void main(String[] args) {

        // Using List of String
        List<String> names = Arrays.asList("Kaushal2@", "Ravi 12$5", "Suman");
        List<Character> vowelsSet = Arrays.asList('a', 'e', 'i', 'o', 'u');
        Map<String, Map<String, Object>> result = names.stream().collect(Collectors.toMap(name -> name,  value -> {

            Map<String, Object> innerMap = new HashMap<>();

            // find vowels
            String vList = value.toLowerCase().chars().distinct()
                    .mapToObj(m -> (char) m)
                    .filter(Character::isLetter)
                    .filter(f -> vowelsSet.contains(f)).map(String::valueOf).collect(Collectors.joining());

            // find consonants
            String cList = value.toLowerCase().chars().distinct()
                    .mapToObj(m -> (char) m)
                    .filter(Character::isLetter)
                    .filter(f -> !vowelsSet.contains(f)).map(String::valueOf).collect(Collectors.joining());

            // find special Char
            String spList = value.toLowerCase().chars().distinct()
                    .mapToObj(m -> (char) m)
                    .filter(f -> !Character.isLetterOrDigit(f))
                    .map(String::valueOf).collect(Collectors.joining());

            innerMap.put("consonants", cList);
            innerMap.put("vowels", vList);
            innerMap.put("spChar", spList);
            return innerMap;
        }));
        System.out.println(result);


        // Using Single String
        String input = "ka3@ushal";

        Map<String, List<String>> listMap = input.toLowerCase().chars().distinct()
                .mapToObj(m -> (char) m)
                .filter(Character::isLetter)
                .collect(Collectors.groupingBy(g -> vowelsSet.contains(g) ? "vowels" : "consonants"
                        , Collectors.mapping(m -> String.valueOf(m), Collectors.toList())));
        System.out.println(listMap);


        // Using List of String
        Map<String, Map<String, List<String>>> finalResult = names.stream().collect(Collectors.toMap(name -> name, value -> {
            Map<String, List<String>> resultMap = value.toLowerCase().chars().distinct()
                    .mapToObj(m -> (char) m)
                    .filter(Character::isLetter)
                    .collect(Collectors.groupingBy(g -> vowelsSet.contains(g) ? "vowels" : "consonants"
                            , Collectors.mapping(m -> String.valueOf(m), Collectors.toList())));
            return resultMap;
        }));

        System.out.println(finalResult);
    }
}
